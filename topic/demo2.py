# import re
# import jieba as jb
#
#
# def stopwordslist(filepath):
#     stopwords = [line.strip() for line in open(filepath, 'r', encoding='utf-8').readlines()]
#     return stopwords
#
#
# # 对句子进行分词
# def seg_sentence(sentence):
#     sentence = re.sub(u'[0-9\.]+', u'', sentence)
#     # jb.add_word('词汇')		# 这里是加入自定义的词来补充jieba词典
#     sentence_seged = jb.cut(sentence.strip())
#     stopwords = stopwordslist('stopwords.en.txt')  # 这里加载停用词的路径
#     outstr = ''
#     for word in sentence_seged:
#         if word not in stopwords and word.__len__() > 1:
#             if word != '\t':
#                 outstr += word
#                 outstr += " "
#     return outstr
#
#
# file1 = open('../data/Title-Summarys.txt', 'r', encoding='utf-8')
# file2 = open('Title.txt', 'w', encoding='utf-8')
# count=0
# for item in file1:
#     count=count+1
#     if(count%50==0):
#         line=item.split("<eos>")
#         file2.write(line[0]+'\n')
# file1.close()
# file2.close()
# inputs = open('Title.txt', 'r', encoding='utf-8')
#
# count=0
# outputs = open('Title-split.txt', 'w', encoding='utf-8')
# for line in inputs:
#     count=count+1
#     line_seg = seg_sentence(line)  # 这里的返回值是字符串
#     print(count)
#     outputs.write(line_seg + '\n')
# outputs.close()
# inputs.close()
#
# import codecs
# from gensim import corpora
# from gensim.models import LdaModel
# from gensim.corpora import Dictionary
#
# train = []
#
# fp = codecs.open('Title-split.txt', 'r', encoding='utf8')
# for line in fp:
#     if line != '':
#         line = line.split()
#         train.append([w for w in line])
#
# dictionary = corpora.Dictionary(train)
#
# corpus = [dictionary.doc2bow(text) for text in train]
#
# lda = LdaModel(corpus=corpus, id2word=dictionary, num_topics=4, passes=100)
# # num_topics：主题数目
# # passes：训练伦次
# # num_words：每个主题下输出的term的数目
#
# for topic in lda.print_topics(num_words=20):
#     termNumber = topic[0]
#     print(topic[0], ':', sep='')
#     listOfTerms = topic[1].split('+')
#     for term in listOfTerms:
#         listItems = term.split('*')
#         print('  ', listItems[1], '(', listItems[0], ')', sep='')
#
# import pyLDAvis.gensim_models
#
# '''插入之前的代码片段'''
# import codecs
# from gensim import corpora
# from gensim.models import LdaModel
# from gensim.corpora import Dictionary
#
# train = []
#
# fp = codecs.open('感想分词.txt', 'r', encoding='utf8')
# for line in fp:
#     if line != '':
#         line = line.split()
#         train.append([w for w in line])
#
# dictionary = corpora.Dictionary(train)
#
# corpus = [dictionary.doc2bow(text) for text in train]
#
# lda = LdaModel(corpus=corpus, id2word=dictionary, num_topics=4, passes=100)
# # num_topics：主题数目
# # passes：训练伦次
# # num_words：每个主题下输出的term的数目
#
# for topic in lda.print_topics(num_words=20):
#     termNumber = topic[0]
#     print(topic[0], ':', sep='')
#     listOfTerms = topic[1].split('+')
#     for term in listOfTerms:
#         listItems = term.split('*')
#         print('  ', listItems[1], '(', listItems[0], ')', sep='')
#
# d = pyLDAvis.gensim_models.prepare(lda, corpus, dictionary)
#
# '''
# lda: 计算好的话题模型
# corpus: 文档词频矩阵
# dictionary: 词语空间
# '''
#
# # pyLDAvis.show(d)		#展示在浏览器
# # pyLDAvis.displace(d) #展示在notebook的output cell中
# pyLDAvis.save_html(d, 'lda_pass4.html')


# import gensim
# from gensim import corpora, models
# import matplotlib.pyplot as plt
# import matplotlib
# from nltk.tokenize import RegexpTokenizer
# from nltk.stem.porter import PorterStemmer
#
# # 准备数据
# PATH = "Title-split.txt"  # 已经进行了分词的文档（如何分词前面的文章有介绍）
#
# file_object2 = open(PATH, encoding='utf-8', errors='ignore').read().split('\n')
# data_set = []  # 建立存储分词的列表
# for i in range(len(file_object2)):
#     result = []
#     seg_list = file_object2[i].split()  # 读取没一行文本
#     for w in seg_list:  # 读取每一行分词
#         result.append(w)
#     data_set.append(result)
#
# dictionary = corpora.Dictionary(data_set)  # 构建 document-term matrix
# corpus = [dictionary.doc2bow(text) for text in data_set]
# Lda = gensim.models.ldamodel.LdaModel  # 创建LDA对象
#
#
# # 计算困惑度
# def perplexity(num_topics):
#     ldamodel = Lda(corpus, num_topics=num_topics, id2word=dictionary, passes=50)  # passes为迭代次数，次数越多越精准
#     print(ldamodel.print_topics(num_topics=num_topics, num_words=20))  # num_words为每个主题下的词语数量
#     print(ldamodel.log_perplexity(corpus))
#     return ldamodel.log_perplexity(corpus)
#
#
# # 绘制困惑度折线图
# x = range(20, 460,20)  # 主题范围数量
# y = [perplexity(i) for i in x]
# plt.plot(x, y)
# plt.xlabel('主题数目')
# plt.ylabel('困惑度大小')
# plt.rcParams['font.sans-serif'] = ['SimHei']
# matplotlib.rcParams['axes.unicode_minus'] = False
# plt.title('主题-困惑度变化情况')
# plt.show()

import gensim
from gensim import corpora, models
import matplotlib.pyplot as plt
import matplotlib
from nltk.tokenize import RegexpTokenizer
from nltk.stem.porter import PorterStemmer
import gensim
import gensim.corpora as corpora
from gensim.utils import simple_preprocess
from gensim.models import CoherenceModel

# 准备数据
PATH = "Title-split.txt"  # 已经进行了分词的文档（如何分词前面的文章有介绍）

file_object2 = open(PATH, encoding='utf-8', errors='ignore').read().split('\n')
data_set = []  # 建立存储分词的列表
for i in range(len(file_object2)):
    result = []
    seg_list = file_object2[i].split()  # 读取没一行文本
    for w in seg_list:  # 读取每一行分词
        result.append(w)
    data_set.append(result)
# print(data_set)  # 输出所有分词列表

dictionary = corpora.Dictionary(data_set)  # 构建 document-term matrix
corpus = [dictionary.doc2bow(text) for text in data_set]
Lda = gensim.models.ldamodel.LdaModel  # 创建LDA对象


def coherence(num_topics):
    print("count")
    ldamodel = Lda(corpus, num_topics=num_topics, id2word=dictionary, passes=50)  # passes为迭代次数，次数越多越精准
    coherence_model_lda = CoherenceModel(model=ldamodel, texts=data_set, dictionary=dictionary, coherence='c_v')
    coherence_lda = coherence_model_lda.get_coherence()
    print('\nCoherence Score: ', coherence_lda)
    return coherence_lda


# 绘制困惑度折线图

if __name__ == "__main__" :
    x = range(20, 260, 20)  # 主题范围数量
    # y = [coherence(i) for i in x]
    y=[0.4926,0.6065,0.6035,0.5377,0.5047,0.5128,0.5495,0.5896,0.7871,0.6425,0.6634,0.7347]
    plt.plot(x, y)
    plt.xlabel('num topics')
    plt.ylabel('coherence score')
    plt.rcParams['font.sans-serif'] = ['SimHei']
    matplotlib.rcParams['axes.unicode_minus'] = False
    plt.title('coherence_values')
    plt.savefig("3-2.png")
    plt.show()