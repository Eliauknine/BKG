import csv

from description import bug_id
from stackoverflow.stackover import create


def readTxt(id):
    file = open('./result/'+str(id)+'.txt','r',encoding='utf-8')
    content=[]
    for item in file:
        content.append(item)

    return content

def write():
    file2 = open('./Aggregate/Summary.txt','r',encoding='utf-8', errors='ignore')
    con = file2.readlines()
    bugzilla,sheet=create(0,'bug',2)
    bugId=bug_id()
    count=1
    cou=0    #记录创建的表格数，五万行一个表
    url = 'https://bugs.eclipse.org/bugs/show_bug.cgi?id='
    for i in range(0,len(bugId)):
        content = readTxt(bugId[i])
        if(content==[]):
            continue
        print(bugId[i],"  ",count)
        content0 = content[0]
        len1=len(bugId[i])
        content0 =content0[len1+1:]
        print(content0)
        sheet.write(count, 0, content0)
        sheet.write(count, 3, url + str(bugId[i]))
        sheet.write(count, 4, con[i])
        if(len(con[i])>32769):
            print(bugId[i],'  ',i)
        count = count+1
        for j in range(1,len(content),2):

            sheet.write(count, 0, url + str(bugId[i]))
            sheet.write(count, 1, content[j])
            sheet.write(count, 2, 'has_buggycode')
            count = count+1
            sheet.write(count, 0, content[j])
            sheet.write(count, 1, content[j+1])
            sheet.write(count, 2, 'has_fixedcode')
            if (len(content[j]) > 32769 or len(content[j+1])>32769):
                print( bugId[i])
            count = count + 1
        if (count > 50000):
            count = 1;
            cou = cou + 1
            savepath =  './bugrdf/bugs'+str(cou)+'.xlsx'
            bugzilla.save(savepath)
            bugzilla, sheet = create(cou,'bug',2)


    savepath =  './bugrdf/bugs'+str(cou+1)+'.xlsx'
    bugzilla.save(savepath)


write()

