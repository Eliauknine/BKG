import matplotlib
from matplotlib import pyplot as plt

perplexity=[279.94,259.45,242.7,229.4,220.5,206.2,202.4,197.1,192.0,188,
            190,186.4]


print(len(perplexity))
# 绘制困惑度折线图
x = range(20,260,20)  #主题范围数量
y = perplexity
plt.plot(x, y)
plt.xlabel('num topics')
plt.ylabel('perplexity score')
plt.rcParams['font.sans-serif']=['SimHei']
matplotlib.rcParams['axes.unicode_minus']=False
plt.title('confusion_values')
plt.savefig("3-1.png")
plt.show()
