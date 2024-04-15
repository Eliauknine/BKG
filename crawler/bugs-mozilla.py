#爬取网页
import csv
import urllib.request
from bs4 import BeautifulSoup
import re


findLink = re.compile(r'"url":"(.*?)"}')      #创建正则表达式对象，表示规则（字符串模式）
findCode1 = re.compile(r'aaa[ ](.*?)aaaa')
findCode2 = re.compile(r'aaaa[ ](.*?)aa')
findNum = re.compile(r',([0-9]*)')
findMethod = re.compile(r'[ ]@@(.*)')
findSum1 = re.compile(r'{')
findSum2 = re.compile(r'}')
#获取bug-id
def bug_id():
    f=open("..//data//bugs-mozilla.csv","r",encoding = 'UTF-8')
    content=csv.reader(f)
    bugId=[]
    bugSummary=[]
    for temp in content:
        bugId.append(temp[0])
        bugSummary.append(temp[1])
    f.close()
    return bugId,bugSummary

def main():
    baseurl = "https://github.com/search?q=bug+"
    #1.爬取网页
    datalist = getData(baseurl)
    savepath=".\\bug.xls"
    #3.保存数据
    #saveData(savepath)

    # askURL("https://bugs.eclipse.org/bugs/show_bug.cgi?id=1")
    # bug_id()


import Levenshtein
def get_equal_rate_2(str1, str2):
   return Levenshtein.ratio(str1, str2)

#爬取网页
def getData(baseurl):
    datalist=[]
    bugId,bugSummary=bug_id()
    # for i in range(0,1):
    for i in range(207,len(bugId)-1):
        print(bugId[i])
        url=baseurl+str(bugId[i+1])+"&type=commits"
        # print(url)
        html = askURL(url)        #保存获取到的网页原码
        #2.逐一解析数据
        soup =BeautifulSoup(html, "html.parser")
        item = soup.select_one(".message.markdown-title.js-navigation-open")
        title=item.get_text()
        bugid=str(bugId[i+1])
        Summary="bug "+bugid+bugSummary[i+1]
        if get_equal_rate_2(title,Summary)>0.8:
        # if title==bugSummary[i+1]:
            print(title,bugSummary[i+1])
            route = "./result/" + str(bugId[i + 1]) + ".txt"
            file = open(route, "a")
            file.writelines([bugId[i+1]," ",bugSummary[i+1],"\n"])
            href=item['href']
            href="https://github.com"+href+"?diff=split"
            html = askURL(href)
            soup = BeautifulSoup(html, "html.parser")
            item = soup.select(".blob-code.blob-code-inner.blob-code-hunk")
            Method = []  # public String getUserID()   全部

            num = 0
            for m in item:
                codeMethod = m.get_text()  # @@ -96,6 +97,7 @@ public synchronized ITransportConfig getConfig()
                if (codeMethod):
                    method = re.findall(findMethod, codeMethod)  # 方法名 public.....  第一个
                    Method.append(method)
                # print(Method)
            codes = soup.select("tr[data-hunk]")
            for temp in codes:
                commit = temp.get("data-hunk")
                break;
            code1 = ""
            code2 = ""
            for n in codes:
                code = n.get_text()
                commits = n.get("data-hunk")
                # n = str(n)
                # isempty1 = re.findall(findEmpty1,n)
                # isempty2 = re.findall(findEmpty2,n)
                code = str(code)
                code = code.replace("\n", "a")
                str1 = re.findall(findCode1, code)
                str2 = re.findall(findCode2, code)
                if (commits == commit):
                    if (str1 != [] and str1 != ['']):
                        code1 = code1 + str1[0] + " "
                    if (str2 != [] and str2 != ['']):
                        code2 = code2 + str2[0] + " "
                else:
                    commit = commits
                    sum1 = code1.count("{") - code1.count("}")
                    sum2 = code2.count("{") - code2.count("}")
                    print(sum1, sum2)
                    while (sum1 != 0):
                        code1 = code1 + "} "
                        sum1 = sum1 - 1
                    while (sum2 != 0):
                        code2 = code2 + "}"
                        sum2 = sum2 - 1
                    if ('public' not in code1):
                        file.writelines([Method[num][0], "{ ", code1, "} ","\n", Method[num][0], "{ ", code2, "}", "\n"])
                    else:
                        file.writelines([code1, "\n", code2, "\n"])
                    code1 = ""
                    code2 = ""
                    if (str1 != [] and str1 != ['']):
                        code1 = code1 + str1[0]
                    if (str2 != [] and str2 != ['']):
                        code2 = code2 + str2[0]
                    num = num + 1
            sum1 = code1.count("{") - code1.count("}")
            sum2 = code2.count("{") - code2.count("}")
            while (sum1 != 0):
                code1 = code1 + "} "
                sum1 = sum1 - 1
            while (sum2 != 0):
                code2 = code2 + "}"
                sum2 = sum2 - 1
            if ('public' not in code1):
                file.writelines([Method[num][0], "{ ", code1, "} ","\n", Method[num][0], "{ ", code2, "}", "\n"])
            else:
                file.writelines([code1, "\n", code2, "\n"])
                # print
            file.close()
        #     # return datalist

#得到指定一个URL的网页内容
def askURL(url):
    head={        #模拟浏览器头部信息，向指定浏览器发送消息
        "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36"
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

