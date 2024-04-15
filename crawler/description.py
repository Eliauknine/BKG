#爬取网页
import csv
import os
import urllib.request
from bs4 import BeautifulSoup
import re

#获取bug-id
def bug_id():
    # path定义要获取的文件名称的目录
    path = "D:/yan/python_project/BFKG/crawler/result"
    bugId=[]
    # os.listdir()方法获取文件夹名字，返回数组
    file_name_list = os.listdir(path)
    file_name_list.sort(key=lambda x: int(x[:-4]))
    for i in range(0,len(file_name_list)):
        bugId.append(file_name_list[i][:-4])
    return bugId


def main():
    baseurl = "https://bugs.eclipse.org/bugs/show_bug.cgi?id="
    #1.爬取网页
    getData(baseurl)
    write()

#爬取网页
def getData(baseurl):
    file = open('./Aggregate/Summary.txt', 'w', encoding='utf-8')
    bugId = bug_id()
    for i in range(0,len(bugId)):
        print(bugId[i])
        url=baseurl+str(bugId[i])
        # print(url)
        html = askURL(url)        #保存获取到的网页原码
        #2.逐一解析数据
        soup =BeautifulSoup(html, "html.parser")
        item = soup.select_one(".bz_comment_text")
        question = item.get_text()
        question = question.replace('\n',' ')
        print(question)
        file.write(question+'\n')
    file.close()

def write():
    bugId = bug_id()
    file = open('../data/bugs-eclipse.csv', 'r', encoding='utf-8')
    file2 = open('./Aggregate/Summary.txt', 'r', encoding='utf-8')
    file3 = open('../data/Title-Summary.txt', 'a', encoding='utf-8')
    file4 = open('../data/stackTag.txt', 'a', encoding='utf-8')
    content = csv.reader(file)
    i=0;
    for item in content:
        if (item[0] in bugId):
            # file3.write(item[6]+' <eos> '+content2[i])
            file4.write(item[1]+';'+item[2]+'\n')
            i=i+1
    file.close()
    file2.close()
    file3.close()
    file4.close()




#得到指定一个URL的网页内容
def askURL(url):
    head={        #模拟浏览器头部信息，向指定浏览器发送消息
        "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
    }
                  #用户代理，表示告诉网页，我们是什么类型的机器，浏览器（本质上是告诉浏览器我们可以接受什么水平的内容）

    request = urllib.request.Request(url,headers=head)
    html = " "
    try:
        response=urllib.request.urlopen(request)
        html=response.read().decode("utf-8")
        # print(html)
    except urllib.error.URLError as e:
        if hasattr(e,"code"):
            print(e.code)
        if hasattr(e,"reason"):
            print(e.reason)
    return html

if __name__ == '__main__':
    main()

