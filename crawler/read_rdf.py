import csv

from search.Neo4j import Neo4j_Helper

graph = Neo4j_Helper("http://localhost:7474", 'neo4j', '990410')
graph.connect_neo4j_service()



# 删除所有的数据   match (n) detach delete n
def readbugzilla(i):
    with open("./bugrdf/bug"+str(i+1)+'.csv', 'r', encoding='utf-8',errors='ignore') as file:
        reader = csv.reader(file)
        sign = False
        for item in reader:

            # print(reader.line_num,item)
            if reader.line_num == 1:
                continue
            if (item[1] == "" ):  # bugzilla
                sign = True
                graph.create_node('bugzilla', {'Title':  item[0], "url": item[3], "Sumarry": item[4]})

            elif(item[2]=='has_buggycode' and sign==True):
                graph.create_node('buggycode', {'buggy_code': item[1]})
                # print(item[1])
                graph.create_one_relationship('buggycode', {'buggy_code': item[1]}, 'bugzilla', {"url": item[0]}, 'has_buggycode')

            elif (item[2] == 'has_buggycode' and sign == False):
                graph.create_one_relationship('buggycode', {'buggy_code': item[1]}, 'bugzilla', {"url": item[0]},
                                              'has_buggycode')
            elif(sign==True):  # 正确代码和错误代码

                graph.create_node('fixedcode', {'fixed_code': item[1]})
                graph.create_one_relationship('fixedcode', {'fixed_code': item[1]}, 'buggycode', {'buggy_code': item[0]},
                                             'has_fixedcode')
                sign==False
            else:
                print(reader.line_num)
                graph.create_one_relationship('fixedcode', {'fixed_code': item[1]}, 'buggycode',
                                              {'buggy_code': item[0]},
                                              'has_fixedcode')



if __name__ == '__main__':
    for i in range(0,2):
        readbugzilla(i)
