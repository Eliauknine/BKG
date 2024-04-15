import os

import jieba.analyse
import numpy as np
import yake
from py2neo import Graph, NodeMatcher
from py2neo.matching import RelationshipMatcher
from gensim.models import Word2Vec
from scipy import spatial

from TAKG.write_rdf import topwords
from TAKG.read_rdf import readTopic
from crawler.read_rdf import readbugzilla
from stackoverflow.stack_rdf import readStackoverflow

model = Word2Vec.load("../TAKG/word_embedding")
graph = Graph('http://localhost:7474', user='neo4j', password='990410')


def cerate():   #创建图
    for i in range(0,2):
        readbugzilla(i)
    for i in range(0,20):
        readStackoverflow(i)
    readTopic()

def findStack(topic) :   #找到最相似主题下的帖子
    node=[[],[]]
    topic=list(topic)
    node_matcher = NodeMatcher(graph)
    relationship_matcher = RelationshipMatcher(graph)
    for i in range(0,len(topic)):
        node1 = node_matcher.match("topic").where(Topic='Topic'+str(topic[i])).first()
        relationship = list(relationship_matcher.match([node1], r_type=None))
        for item in relationship:
            node[i].append(item.end_node['url'])
    if node[1]!=[]:
        f_node = list(set(node[0]).intersection(set(node[1])))
    else:
        f_node = node[0]
    return f_node



def similarcode():    #相似代码检测
    codeId = []  # 记录相似代码的Id
    cmd = 'cd D:/yan/python_project/CCFinderSW-1.0/bin && CCFinderSW D -d D:/yan/python_project/BFKG/search/result -l java -o outputfile -ccfsw set -t 80 '
    os.system(cmd)


    file = open('D:/yan/python_project/CCFinderSW-1.0/bin/outputfile_ccfsw.txt', 'r', encoding='utf-8')
    for item in file:
        if ('cloneID:1' in item):
            break
    file_numberA = file.readline()
    file_numberB = []
    if '0:' in file_numberA:
        for item in file:
            if ('cloneID' in item):
                break
            number = item.split(':')
            num = number[0]  # 相似代码的id
            file_numberB.append(num[1:])

    file.close()

    file = open('D:/yan/python_project/CCFinderSW-1.0/bin/outputfile_ccfsw.txt', 'r', encoding='utf-8')

    for item in file:
        if '#source_files' in item:
            break

    for item in file:
        item = item.split('	')
        if item[0] in file_numberB:
            id = item[3].split('code')[1][:-6]
            id = int(id)
            codeId.append(id)
    return codeId



# 采用jieba进行分词，分词后计算每个词的词向量，最后求平均值；
def avg_string_vector(sentence, model):
    model_dimension = 128  # 该模型的维度为128维
    words = jieba.cut(sentence)  # 默认jieba精确分词模式
    string_vec = np.zeros((model_dimension,), dtype='float32')  # 返回1个"1*256"，元素为0的数组；
    num_words = 0  # 该句话中词语的个数，初始值为0
    for word in words:
        if word in model.wv:
            num_words += 1  # 计算出该句话中，词语的个数
            string_vec = np.add(string_vec, model.wv[word])  # 计算每个分词的词向量，并进行相加；

    if (num_words > 0):
        string_vec = np.divide(string_vec, num_words)  # 求平均值：将词向量相加后的和，除以分词的个数；
    return string_vec


def rank(question,content):   #将获取到的帖子按相似度排名
    score=[]
    que_vec = avg_string_vector(question,model=model)
    for item in content:
        s_vec = avg_string_vector(item,model=model)
        score.append(1 - spatial.distance.cosine(que_vec, s_vec))
    score = np.array(score)
    return  (np.argsort(-score))




def Search():
    question = input("请输入问题：")
    code = input("请输入问题代码（没有请输入N）：")
    keyword_extracted=[]
    kw_extractor = yake.KeywordExtractor(top=2, stopwords=None, n=1)
    keywords = kw_extractor.extract_keywords(question)
    for kw, v in keywords:
        keyword_extracted.append(kw)
    topic=topwords()
    result=[]
    for ent in keyword_extracted:   #关键词
        if ent not in model.wv:
            ent=ent.lower()
            if ent not in model.wv:
                continue
        simility=[]
        sum=[0]*320
        for item in topic:
            simility.append(model.wv.similarity(ent, item))
        if(simility==0):
            continue
        for i in range(0, 320):
            for j in range(0, 10):
                sum[i] = simility[10 * i + j] + sum[i]
        result.append(sum.index(max(sum)))
    result=set(result)
    print("..............1.开始寻找最相似主题下的帖子..........")
    url_node=findStack(result)
    node_matcher = NodeMatcher(graph)
    relationship_matcher = RelationshipMatcher(graph)
    content_t = []   #记录标题信息
    content_q = []    #记录问题信息
    content_u = []   #记录url索引信息
    print("..............2.获取相似帖子下的内容..........")
    for url in url_node:
        if('stackoverflow' in url):
            node1 = node_matcher.match("stackoverflow").where(url=url).first()
            content_q.append(node1)
        else:
            node2 = node_matcher.match("bugzilla").where(url=url).first()
            content_t.append(node2['Title'])
            content_q.append(node2)

    score=rank(question,content_t)
    del content_t
    if(code == 'N' or code=='n'):
        print("..............3.输出相似帖子下的内容..........")
        count=0
        for i in score:       ##输出前十个的帖子信息
            print(content_q[i])
            count = count + 1
            if(count==10):
                break

    if(code != 'N' and code!='n'):
        print("..............3.获取相似帖子下的错误代码..........")
        file = open('./result/code.java', 'w', encoding='utf-8')
        file.write(code)
        file.close()
        i=0
        file2 = open('./url.txt', 'w', encoding='utf-8')
        for node in content_q:   #content_q:完整的节点信息（问题），通过节点找边
            relationship = list(relationship_matcher.match([node], r_type=None))
            if(relationship==[]):
                continue
            for item in relationship:
                content_u.append(node['url'])
                file2.write(node['url'])
                file = open('./result/code' + str(i) + '.java', 'w', encoding='utf-8')
                file.write(item.end_node['buggy_code'])
                i = int(i)
                i = i + 1
                file.close()
        file2.close
        del content_q
        print("..............4.计算相似度..........")
        codeId = similarcode()
        print("..............5.输出结果..........")
        for id in codeId:
            if 'stackoverflow' in content_u[id]:
                node1 = node_matcher.match("stackoverflow").where(url=content_u[id]).first()
                print(node1)
            else:
                file = open('./result/code' + str(id) + '.java', 'r', encoding='utf-8')
                buggycode = file.readline()
                node1 = node_matcher.match("bugzilla").where(url=content_u[id]).first()
                print(node1)
                node2 = node_matcher.match("buggycode").where(buggy_code=buggycode).first()
                relationship = list(relationship_matcher.match([node2], r_type=None))
                print('错误代码:', buggycode)
                for item in relationship:
                    print('正确代码:', item.end_node['fixed_code'])


if __name__=='__main__':
    #1.创建图
    # cerate()
    #2.搜索
    Search()   #574688







