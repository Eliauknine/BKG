import numpy as np
from gensim.models import Word2Vec
from gensim.models.word2vec import LineSentence

def merge():   #将拆分的五个预测集合并
    file1 = open('./pre/prediction1.txt', 'r', encoding='utf-8')
    file2 = open('./pre/prediction2.txt', 'r', encoding='utf-8')
    file3 = open('./pre/prediction3.txt', 'r', encoding='utf-8')
    file4 = open('./pre/prediction4.txt', 'r', encoding='utf-8')
    file5 = open('./pre/prediction5.txt', 'r', encoding='utf-8')
    file6 = open('pre/prediction.txt', 'w', encoding='utf-8')

    content1 = file1.readlines()
    content2 = file2.readlines()
    content3 = file3.readlines()
    content4 = file4.readlines()
    content5 = file5.readlines()

    for i in range(0, 182960, 10):
        for j in range(0, 10):
            file6.write(content1[i + j])
        for k in range(0, 10):
            file6.write(content2[i + k])
        for l in range(0, 10):
            file6.write(content3[i + l])
        for m in range(0, 10):
            file6.write(content4[i + m])
        for n in range(0, 10):
            file6.write(content5[i + n])

    for i in range(0, 10):
        file6.write(content1[i + 182960])
    for i in range(0, 10):
        file6.write(content2[i + 182960])
    for i in range(0, 10):
        file6.write(content3[i + 182960])
    for i in range(0, 5):
        file6.write(content4[i + 182960])

    file1.close()
    file2.close()
    file3.close()
    file4.close()
    file5.close()
    file6.close()

def trans():
    file=open('./pre/prediction.txt','r',encoding='utf-8')
    file2 = open('./pre/predictions.txt', 'w', encoding='utf-8')
    for item in file:
        item=item.replace(';;',';')
        if(item[-2]==';'):
            item=item[0:-2]+'\n'
        file2.write(item)
    file.close()
    file2.close()


def topwords():   #读取460*10个主题
    file = open(r'D:\yan\python_project\BFKG\TAKG\pre\topwords_e100.txt','r',encoding='utf-8')
    topic=[]
    for line in file:
        line=line[0:-1]
        line=line.split(' ')
        topic=topic+line
    return topic


def train():
    # 训练模型
    sentences = LineSentence('../data/Title-Summary.txt')
    model = Word2Vec(sentences, vector_size=128, window=5, min_count=5, workers=8)

    # 保存模型
    model.save('./TAKG/word_embedding')

def similar(con):
    sim = np.zeros((320,10))
    i=0
    count=0
    sum=[0]*320
    if con =='<eos>':
        return -1

    elif con in top and con not in model.wv:  #预测词在主题集中，且不在model里
        listAdd = ([k for k ,item in enumerate(top) if item is con])   #记录不在model里面的词，但是在top里面的词的所有下标
        for listadd in listAdd:
            sim[listadd/10][listadd%10]=1
        print('1')

    elif con not in model.wv:     #预测词不在主题集中，且不在model里
        print('2',' ',con)
        j=0
        if '-' in con:
            content = con.split('-')
            # print(content)
            con =content[j]
            if con not in model.wv:
                j=j+1
                con = content[j]
        # print('22', ' ', con)

    if con in model.wv:
        for item in top:
            # print(item,'   ',con)
            if item in model.wv:
                sim[count][i] = model.wv.similarity(item, con)
                # print('a',sim[count][i])
            elif con == item:
                sim[count][i] = 1
                # print('b', sim[count][i])
            else:
                sim[count][i] = 0
                # print('c', item,'  ' ,con,'  ',sim[count][i])
            i = i + 1
            if (i == 10):
                i = 0
                count = count + 1
    for i in range(0,320):
        for j in range(0, 10):
            sum[i]=sim[i][j]+sum[i]
    print(sum)
    return sum.index(max(sum))



def predict():   #判断每个title属于什么集合
    file = open('pre/predictions.txt', 'r', encoding='utf-8')
    file2 = open('./rdf/topic_rdf.csv', 'w', encoding='utf-8')
    file3 = open('../data/url.txt', 'r', encoding='utf-8')
    count=0;
    for item in file:
        content = file3.readline()
        count=count+1
        if(count>300000):
            break
        print(count, '  ', item)
        item = item[0:-1]
        item=item.split(';')

        content = content[:-1]
        for con in item:
            # print(con,similar(con))
            # similarity.append(similar(con))

            file2.writelines([content,',Topic',str(similar(con)),',has_question\n'])
    # return similarity
    file.close()
    file2.close()
    file3.close()




if __name__=='__main__':
    top = topwords()
    #训练模型
    # train()
    # 加载模型
    model = Word2Vec.load("./word_embedding")
    # merge()
    # trans()
    # predict()
    score=similar('EMF')
    print(type(score))
    if(score==0):
        print('lll')







