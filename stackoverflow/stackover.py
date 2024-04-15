import re
from xml.etree import ElementTree as ET
import xlwt



findCode=re.compile(r'<pre><code>(.*?)</code></pre>')
findTag=re.compile(r'<(.*?)>')
findSummary=re.compile(r'<p>(.*?)</p>')
findA=re.compile(r'<a href(.*?)>')
findDiv=re.compile(r'<div class="snippet"(.*?)</div>\s\s</div>')
url="https://stackoverflow.com/questions/"

import xlrd
from xlutils.copy import copy



def has_same(str,str2):
    lst=list(set(str) & set(str2))
    if lst ==[]:
        return True
    else:
        return False

def name(formname,length):   #创建表格
    sheetname=[]
    for i in range(0,length):
        sheetname.append(formname+str(i))
    return sheetname

def create(con,formname,length):
    sheetname = name(formname,length)
    stack = xlwt.Workbook(encoding='utf-8', style_compression=0)
    sheet = stack.add_sheet(sheetname[con], cell_overwrite_ok=True)
    col = ('head', 'tail', 'relation', 'properties')
    for i in range(0, 4):
        sheet.write(0, i, col[i])
    return stack,sheet

def write():
    #创建表格
    sheetcon = 20  # 记录表格
    content = []
    content2 = []  # 记录title
    content3 = []  # 记录id->url
    content4 = []  # 记录question
    content5 = []  # 记录code
    content6 = []   #记录tag
    content7 = []   #记录Summary
    # file = open('./data/Title-Summary.txt', 'w', encoding='utf-8')
    # file2=open('../data/stackTag.txt','w',encoding='utf-8')
    # file3 = open('../data/url.txt','w',encoding='utf-8')
    count=1
    print(sheetcon)
    stack,sheet=create(sheetcon,'stack',30)
    # 直接解析xml文件
    tree = ET.parse("../data/stackPosts.xml")
    # 获取跟标签
    root = tree.getroot()
    # 获取根标签的孩子标签
    for child in root:

        # print(child)
        code2 = []  # 纯代码块，记录一个页面行数大于3的代码块
        PostTypeId = child.attrib.get('PostTypeId')
        PostTypeId = int(PostTypeId)
        Id = child.attrib.get("Id")
        Id = int(Id)
        if (PostTypeId == 1):

            AcceptedAnswerId = child.attrib.get('AcceptedAnswerId')
            if (AcceptedAnswerId == None):
                continue
            Question = child.attrib.get('Body')
            Summary = ''
            AllSummary = re.findall(findSummary, Question)
            for item in range(0, len(AllSummary)):
                Summary = Summary + AllSummary[item]

            code = re.findall(findCode, Question)  # 有可能含有报错信息以及其他代码
            Title = child.attrib.get('Title')
            Tag = child.attrib.get('Tags')
            AcceptedAnswerId = int(AcceptedAnswerId)
            content.append(AcceptedAnswerId)  # 记录title信息，便于后期添加question属性
            content2.append(Title)
            content3.append(Id)
            content4.append(Question)
            content6.append(Tag)
            content7.append(Summary)

            for item in code:
                if (item.count(';')) > 3:  # 过滤掉小于4行的代码以及错误信息
                    code2.append(item)
            if (code2 == [] or len(code2) != 1):
                content5.append('')
                continue
            content5.append(code2[0])

        elif (Id in content):  # 判断对应的title是否存在
            Answer = child.attrib.get('Body')
            Answer = Answer.replace("\n", " ")
            Answer = Answer.replace("&lt;", "<")
            Answer = Answer.replace("&gt;", ">")
            code = re.findall(findCode, Answer)
            add = content.index(Id)
            Summary = summary(content7[add])
            # file.write(content2[add] + ' <eos> ' + Summary + '\n')
            # file2.write(content6[add] + '\n')
            # file3.write(url + str(content3[add]) + '\n')
            if (len(code) == 1 and content5[add]!=''):
                sheet.write(count, 0, content2[add])
                sheet.write(count, 1, content5[add])
                sheet.write(count, 2, "has_buggycode")  # 添加title和buggcode(has_buggycode)关系
                sheet.write(count, 3, url + str(content[add]))  # 添加url和question description属性
                sheet.write(count, 4, content4[add])
                sheet.write(count, 5, Answer)
                count = count + 1
                sheet.write(count, 0, content5[add])
                sheet.write(count, 1, code)
                sheet.write(count, 2, "has_fixed")
                count = count + 1
            else:
                sheet.write(count, 0, content2[add])
                sheet.write(count, 3, url + str(content3[add]))  # 添加url和question description属性
                sheet.write(count, 4, content4[add])
                sheet.write(count, 5, Answer)
                count = count + 1

            del content[add]
            del content2[add]
            del content3[add]
            del content4[add]
            del content5[add]
            del content6[add]
            del content7[add]

        if(count>50000):
            print(sheetcon)
            count=1;
            sheetcon=sheetcon+1
            savepath = './stack'+str(sheetcon)+'.xlsx'
            stack.save(savepath)
            stack, sheet = create(sheetcon)
    # file.close()
    # file2.close()
            # if(Id2==AcceptedAnswerId):
            #     Answer = childs.attrib.get('Body')
            #     break;
    print(count)


def convert():   #处理获取到的tags标签，将格式转换成TAKG的输入格式
    file = open('./data/stackTags.txt', 'w', encoding='utf-8')
    file2 = open('./data/stackTag.txt', 'r', encoding='utf-8')

    for line in file2:
        line = line.replace('><', ';')
        line = line.replace('<', '')
        line = line.replace('>', '')
        file.write(line)
    file.close()
    file2.close()


def summary(line):    #去掉所有标签和代码
    code = re.findall(findCode, line)
    for i in range(0, len(code)):
        line = line.replace(code[i], '')
    line = line.replace('<code>', '')
    line = line.replace('</code>', '')
    line = line.replace('<p>', '')
    line = line.replace('</p>', '')
    line = line.replace('<em>', '')
    line = line.replace('</em>', '')
    line = line.replace('<blockquote>', '')
    line = line.replace('</blockquote>', '')
    line = line.replace('<strong>', '')
    line = line.replace('</strong>', '')
    line = line.replace('<ol>', '')
    line = line.replace('</ol>', '')
    line = line.replace('<li>', '')
    line = line.replace('</li>', '')
    line = line.replace('<br/>', '')
    labelA = re.findall(findA, line)
    for i in range(0, len(labelA)):
        labelA[i] = '<a href' + labelA[i] + '>'
        line = line.replace(labelA[i], '')
    line = line.replace('</a>', '')
    line = line.replace('<pre>', '')
    line = line.replace('</pre>', '')
    return line

def delete(): #去掉java标签
    file = open('../data/stackTags.txt','r',encoding='utf-8')
    file2 = open('../data/stackTag.txt','w',encoding='utf-8')
    for line in file:
        if line=='java':
            continue
        else:
            line=line.replace('java;','')
            line = line.replace(';java', '')
        file2.write(line)
    file.close()
    file2.close()


def lower():   #将大写全部改为小写
    file = open('../data/Title-Summary.txt',encoding='utf-8')
    file2 = open('../data/Title-Summarys.csv', 'w', encoding='utf-8')
    item=file.readlines()
    for i in item:
        file2.write(i.lower())
    file2.close
    file.close


def split():  #划分训练集测试集
    count=0
    file = open('../data/Title-Summarys.csv', 'r', encoding='utf-8')
    file2 = open('../data/StackExchange/train_src.txt', 'w', encoding='utf-8')
    file3 = open('../data/stackTag.txt', 'r', encoding='utf-8')
    file4 = open('../data/StackExchange/train_trg.txt', 'w', encoding='utf-8')
    file5 = open('../data/StackExchange/valid_src.txt', 'w', encoding='utf-8')
    file6 = open('../data/StackExchange/valid_trg.txt', 'w', encoding='utf-8')
    file7 = open('../data/StackExchange/test_src.txt', 'w', encoding='utf-8')
    file8 = open('../data/StackExchange/test_trg.txt', 'w', encoding='utf-8')
    file9 = open('../data/StackExchange/test_src2.txt', 'w', encoding='utf-8')
    file10 = open('../data/StackExchange/test_trg2.txt', 'w', encoding='utf-8')
    file11 = open('../data/StackExchange/test_src3.txt', 'w', encoding='utf-8')
    file12 = open('../data/StackExchange/test_trg3.txt', 'w', encoding='utf-8')
    file13 = open('../data/StackExchange/test_src4.txt', 'w', encoding='utf-8')
    file14 = open('../data/StackExchange/test_trg4.txt', 'w', encoding='utf-8')
    file15 = open('../data/StackExchange/test_src5.txt', 'w', encoding='utf-8')
    file16 = open('../data/StackExchange/test_trg5.txt', 'w', encoding='utf-8')
    for item in file:
        count=count+1
        if(count<=8):
            file2.write(item)
            file7.write(item)
        elif(8<count<=10):
            file5.write(item)
            file7.write(item)
        elif(10<count<=20):
            file9.write(item)
        elif (20 < count <= 30):
            file11.write(item)
        elif (30 < count <= 40):
            file13.write(item)
        elif (40 < count <= 50):
            file15.write(item)
        if(count==50):
            count=0

    count=0
    for item in file3:
        count = count + 1
        if (count <= 8):
            file4.write(item)
            file8.write(item)
        elif (8 < count <= 10):
            file6.write(item)
            file8.write(item)
        elif (10 < count <= 20):
            file10.write(item)
        elif (20 < count <= 30):
            file12.write(item)
        elif (30 < count <= 40):
            file14.write(item)
        elif (40 < count <= 50):
            file16.write(item)
        if(count==50):
            count = 0
    file.close()
    file2.close()
    file3.close()
    file4.close()
    file5.close()
    file6.close()
    file7.close()
    file8.close()
    file9.close()
    file10.close()
    file11.close()
    file12.close()
    file13.close()
    file14.close()
    file15.close()
    file16.close()

if __name__ == '__main__':
    # lower()
    # split()
    write()
