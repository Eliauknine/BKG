import heapq
from xml.etree import ElementTree as ET

import numpy as np


def create():
    tree = ET.parse("../data/stackPosts.xml")

    content = []  # 记录Score
    content2 = []  # 记录ViewCount

    file = open("./question.txt", "w", encoding="utf-8")
    file2 = open("./answer.txt", "r", encoding="utf-8")
    arr = []
    for item in file2:
        item1=item.split("   ")
        arr.append(item1[0])
    # 获取跟标签
    root = tree.getroot()
    # 获取根标签的孩子标签
    for child in root:
        PostTypeId = child.attrib.get('PostTypeId')
        if (PostTypeId == "1"):
            Id = child.attrib.get("Id")
            Score = child.attrib.get('Score')
            ViewCount = child.attrib.get('ViewCount')
            if(Id in arr):
                file.write(Score + "   " + ViewCount + "\n")
        # else:
        #     ParentId=child.attrib.get('ParentId')
        #     Score = child.attrib.get('Score')
        #     file2.write(ParentId+"   "+Score + "\n")

    file.close()
    file2.close()

def count():
    file = open("./question.txt", "r", encoding="utf-8")
    file2 = open("./answer.txt", "r", encoding="utf-8")

    count1 = 0
    count2 = 0
    count3 = 0
    count4 = 0
    count5 = 0
    count6 = 0
    count7 = 0
    for item in file:
        item1 = item.split("   ")
        con = int(item1[1])
        if (con > 10000):
            count1 = count1 + 1
        if (5000 < con < 10001):
            count2 = count2 + 1
        if (1000 < con < 5001):
            count3 = count3 + 1
        if (500 < con < 1001):
            count4 = count4 + 1
        if (100 < con < 501):
            count5 = count5 + 1
        if (con < 101):
            count6 = count6 + 1
    print("view")
    print(count1, "  ", count2, "  ", count3, "  ", count4)
    print(count5, "  ", count6, "  ", count7)


def count2():
    file = open("./question.txt", "r", encoding="utf-8")
    file2 = open("./answer.txt", "r", encoding="utf-8")

    count1 = 0
    count2 = 0
    count3 = 0
    count4 = 0
    count5 = 0
    count6 = 0
    count7 = 0
    for item in file:
        item1 = item.split("   ")
        con = int(item1[0])
        if (con > 50):
            count1 = count1 + 1
        if (30 < con < 51):
            count2 = count2 + 1
        if (10 < con < 31):
            count3 = count3 + 1
        if (5 < con < 11):
            count4 = count4 + 1
        if (0 < con < 6):
            count5 = count5 + 1
        if ( con == 0):
            count6 = count6 + 1
        if (con < 0):
            count7 = count7 + 1
    print("Question_Score")
    print(count1, "  ", count2, "  ", count3, "  ", count4)
    print(count5, "  ", count6, "  ", count7)

def show():
    file = open("./question.txt", "r", encoding="utf-8")


    import numpy as np
    import matplotlib.pyplot as plt
    import pandas as pd
    arr = [[] for i in range(7)]

    for item in file:
        item1 = item.split("   ")
        con = int(item1[0])
        arr[1].append(con)
        # if (con > 50):
        #     # arr[0].append(con)
        #     continue
        # if (40 < con < 51):
        #     arr[1].append(con)
        # if (30 < con < 41):
        #     arr[2].append(con)
        # if (20 < con < 31):
        #     arr[3].append(con)
        # if (10 < con < 21):
        #     arr[4].append(con)
        # if (con == 0):
        #     arr[5].append(con)
        # if (con < 0):
        #     # arr[6].append(con)
        #     continue
    # print(arr)

    view = plt.boxplot(arr)
    plt.show()
    # df.boxplot() #也可用plot.box()
    # plt.show()


def answer():
    count1 = 0
    count2 = 0
    count3 = 0
    count4 = 0
    count5 = 0
    count6 = 0
    count7 = 0
    file2 = open("./answer.txt", "r", encoding="utf-8")
    for item in file2:
        item1=item.split("   ")
        con = int(item1[1])
        if (con > 50):
            count1 = count1 + 1
        if (30 < con < 51):
            count2 = count2 + 1
        if (10 < con < 31):
            count3 = count3 + 1
        if (5 < con < 11):
            count4 = count4 + 1
        if (0 < con < 6):
            count5 = count5 + 1
        if (con == 0):
            count6 = count6 + 1
        if (con < 0):
            count7 = count7 + 1
    print("Answer_Score")
    print(count1, "  ", count2, "  ", count3, "  ", count4)
    print(count5, "  ", count6, "  ", count7)

def viewvount():
    count=[]
    file = open("./question.txt", "r", encoding="utf-8")
    for item in file:
        item1 = item.split("   ")
        con = int(item1[1])
        count.append(con)
    max = heapq.nlargest(50,count)
    con=0
    for item in max:
        print(item,end=" ")
        con = con + 1
        if (con == 10):
            print()
            con = 0
    # print(count[-10:-1])




if __name__=='__main__':
    # count()
    # count2()
    # # show()
    # answer()
    # create()
    viewvount()