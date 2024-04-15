file1=open('./rdf/topicstack.csv','w',encoding='utf-8')
file2=open('./rdf/topic_rdf.csv','r',encoding='utf-8')
file3=open('D:/yan/python_project/bug4/TAKG/rdf/topic_rdf.csv','r',encoding='utf-8')
file4=open('D:/yan/python_project/bug5/TAKG/rdf/topic_rdf.csv','r',encoding='utf-8')

for item in file2:
    file1.write(item)
for item in file3:
    file1.write(item)
for item in file4:
    if(item[0]!=','):
        file1.write(item)

