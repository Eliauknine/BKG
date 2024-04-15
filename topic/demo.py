from matplotlib import pyplot as plt



def perplexity_visible_model(self, topic_num, data_num):
    '''
    @description: 绘制困惑度-主题数目曲线
    @param {type} 
    @return: 
    '''
    # texts = self.fenci_data()
    _, corpus = self.weibo_lda()
    x_list = []
    y_list = []
    for i in range(1, topic_num):
        model_name = './lda_{}_{}.model'.format(i, data_num)
        try:
            lda = models.ldamodel.LdaModel.load(model_name)
            perplexity = lda.log_perplexity(corpus)
            print(perplexity)
            x_list.append(i)
            y_list.append(perplexity)
        except Exception as e:
            print(e)
    plt.xlabel('num topics')
    plt.ylabel('perplexity score')
    plt.legend(('perplexity_values'), loc='best')
    plt.show()

def visible_model(self, topic_num, data_num):
    '''
    @description: 可视化模型
    @param :topic_num:主题的数量
    @param :data_num:数据的量
    @return: 可视化lda模型
    '''
    dictionary, _ = self.weibo_lda()
    texts = self.fenci_data()
    x_list = []
    y_list = []
    for i in range(1, topic_num):
        model_name = './lda_{}_{}.model'.format(i, data_num)
        try:
            lda = models.ldamodel.LdaModel.load(model_name)
            cv_tmp = CoherenceModel(model=lda, texts=texts, dictionary=dictionary, coherence='c_v')
            x_list.append(i)
            y_list.append(cv_tmp.get_coherence())
        except:
            print('没有这个模型:{}'.format(model_name))
    plt.plot(x_list, y_list)
    plt.xlabel('num topics')
    plt.ylabel('coherence score')
    plt.legend(('coherence_values'), loc='best')
    plt.show()


# 找到最佳k通过主题一致性得分去找
import tomotopy as tp

tp.isa


def find_k(docs, min_k=1, max_k=20, min_df=2):
    # min_df 词语最少出现在两个文档中
    import matplotlib.pyplot as plt
    scores = []
    for k in range(min_k, max_k):
        mdl = tp.LDAModel(min_df=min_df, k=k, seed=555)
        # print("mdl",mdl)
        for words in docs:
            if words:
                mdl.add_doc(words)
        mdl.train(20)
        coh = tp.coherence.Coherence(mdl)
        scores.append(coh.get_score())
    plt.plot(range(min_k, max_k), scores)
    plt.xlabel("number of topics")
    plt.ylabel("coherence")
    plt.show()


find_k(docs=df['words'], min_k=1, max_k=40, min_df=2)

