import re
findAccept=re.compile(r'AcceptedAnswerId="(.*?)"')
findId=re.compile(r'row Id="(.*?)"')
AcceptedAnswer=[]


def processing():
    file = open('F:\stackoverflow\stackoverflow.com-Posts\Posts.txt','r',encoding='UTF-8')
    file_save = open('../data/stackPosts.txt','a',encoding='UTF-8')
    Program_Lan=['&lt;c++&gt','&lt;pytho&gt','&lt;c#&gt','&lt;php&gt','&lt;c&gt','&lt;go&gt']

    for line in file:
        if('PostTypeId="1"' in line and '&lt;java&gt' in line and any(word if word in line else False for word in Program_Lan)==False):  #判断标签中是否包含其他语言
            file_save.write(line)
            AcceptedAnswerId=re.findall(findAccept,line)
            AcceptedAnswer.append(AcceptedAnswerId)
        else:
            Id = re.findall(findId,line)
            # print(Id)
            if(Id in AcceptedAnswer):
                print(Id)
                file_save.write(line)
                add = AcceptedAnswer.index(Id)
                del AcceptedAnswer[add]

    file.close()
    file_save.close()


if __name__=='__main__':
    processing()
