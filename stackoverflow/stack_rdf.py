import csv
from py2neo import Graph, Subgraph, Node, Relationship
from search.Neo4j import Neo4j_Helper

graph = Neo4j_Helper("http://localhost:7474", 'neo4j', '990410')
graph.connect_neo4j_service()




# 删除所有的数据   match (n) detach delete n



def readStackoverflow(i):  #neo4j中插入节点
    with open("./stackrdf/stack"+str(i+1)+".csv", 'r', encoding='utf-8') as file:
        nodes_list = []  # 一批节点数据
        relations_list = []  # 一批关系数据
        reader = csv.reader(file)
        for item in reader:
            print( reader.line_num)
            if reader.line_num ==1:
                continue
            if (item[1] == ""):  # 不涉及代码的stack帖子页面节点，节点名为title，属性：url,qustion,answer

                graph.create_node('stackoverflow', {'Title': item[0],'url': item[3],'Question': item[4], 'Answer': item[5]})

                #
                # node_1 = Node("stack", url=item[3])
                # properties = {"Title": item[0], "Question": item[4], "Answer": item[5]}
                # node_1.update(**properties)
                # graph.push(node_1)
                # nodes_list.append(node_1)

            elif (item[3] == ""):  # 正确代码和错误代码
                graph.create_node('buggycode', {'buggy_code': item[0]})
                graph.create_node('fixedcode', {'fixed_code': item[1]})
                graph.create_one_relationship('buggycode', {'buggy_code': item[0]}, 'fixedcode', {'fixed_code': item[1]},
                                              'has_fixedcode')


            else:  # 帖子和buggycode
                graph.create_node('stackoverflow', {'Title': item[0], 'url': item[3], 'Question': item[4], 'Answer': item[5]})
                graph.create_node('buggycode', {'buggy_code': item[0]})
                graph.create_one_relationship('stackoverflow', {'url': item[3]}, 'buggycode',
                                              {'buggy_code': item[0]},
                                              'has_buggycode')



if __name__ =='__main__':
    for i in range(18,20):
        print(i)
        readStackoverflow(i)