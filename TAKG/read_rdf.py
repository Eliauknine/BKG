import csv

from py2neo import NodeMatcher

from search.Neo4j import Neo4j_Helper
from TAKG.write_rdf import topwords


graph = Neo4j_Helper("http://localhost:7474", 'neo4j', '990410')
graph.connect_neo4j_service()

matcher = NodeMatcher(graph)
# 删除所有的数据   match (n) detach delete n

def readTopic():
    topic = topwords()
    graph.create_index('topic', 'Topic')
    graph.create_index('stackoverflow', 'url')
    graph.create_index('stackoverflow', 'url')
    for i in range(0, 320):
        topics = ''
        for j in range(0, 10):
            topics = topics + topic[i * 10 + j] + ' '
        # properties = {"KeyWords: ": topics}

        graph.create_node('topic', {'Topic': "Topic" + str(i), 'keyWords': topics})
        # start_node.update(**properties)
        # graph.push(start_node)
        # graph.create(start_node)

    with open(r'./rdf/topicstack.csv', 'r', encoding='utf-8') as file:
        reader = csv.reader(file)
        for item in reader:

            print(reader.line_num)
            # if(reader.line_num<2353631):
            #     continue
            if (item[-2] == 'Topic-1'):
                continue

            result = graph.get_one_node_position('stackoverflow',{'url':item[0]})

            if(result==None):
                print(reader.line_num, item[0])
                continue

            graph.create_one_relationship('stackoverflow', {'url': item[0]}, 'topic', {'Topic': item[-2]}, 'has_question')
            # start_node = Node("topic", Topic=item[-2])
            # end_node = Node("stack", Title=title)
            # relation = Relationship(start_node, 'has_question', end_node)
            # graph.merge(start_node, "topic", "Topic")
            # graph.merge(end_node, "stack", "Title")
            # graph.merge(relation)
    file.close()


    with open(r'./rdf/topicbug.csv', 'r', encoding='utf-8') as file2:
        reader = csv.reader(file2)
        for item in reader:
            print(reader.line_num)
            if(reader.line_num<1499):
                continue
            if (item[-2] != 'Topic-1'):
                graph.create_one_relationship('bugzilla', {'url': item[0]}, 'topic', {'Topic': item[-2]},
                                          'has_question')
    file2.close()


if __name__ == '__main__':
    readTopic()