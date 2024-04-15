# from description import bug_id
#
# bugId=bug_id()
# for i in range(0,len(bugId)):
#     file = open('./result/'+bugId[i]+".txt","r",encoding="utf-8")
#     file2 = open('./result2/'+bugId[i]+".java","w",encoding="utf-8")
#     count=0
#     for item in file:
#         count=count+1
#         if(count%2==0):
#             if("#############" not in item and "import" not in item and "*****************" not in item and "==========" not in item and "package" not in item and "xml version" not in item and "/>" not in item
#             and "org.eclipse" not in item):
#                 file2.write(item)
#             else:
#                 print(item)
#     file.close()
#     file2.close()


file = open('D:/yan/python_project/CCFinderSW-1.0/bin/outputfile_ccfsw.txt',"r",encoding="utf-8")

for item in file:
    if item=='#clone_sets\n':
        break
for item in file:
    if('clone' in  item):
        continue
    num = item.split(":")
    num0=num[0]
    Num = num[1].split('-')
    Num1=Num[0].split(",")
    num1= Num1[1]
    Num2 = Num[1].split(",")
    num2 = Num2[1]
    num1 = int(num1)
    num2=int(num2)
    Num1[0] = int(Num1[0])
    Num2[0] = int(Num2[0])
    # if (Num1[0] == Num2[0]):
    #     print(num1,"   ",num2)
    #     print(num2-num1)
    if(Num1[0]==Num2[0] and num2-num1<200):
        print(item)

