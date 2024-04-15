from py2neo import *
import re

class Neo4j_Helper(object):
    # 设定初始变量
    # 格式：neo4j = Neo4j_Helper("http://localhost:7474", "neo4j", "123456")
    def __init__(self, url, user_name, user_passwd):
        self.url = url
        self.user_name = user_name
        self.user_passwd = user_passwd
        self.graph = None

    # 1.连接服务器
    def connect_neo4j_service(self):
        self.graph = Graph(self.url, auth=(self.user_name, self.user_passwd))

    # 2.创建索引         创建索引对搜索速度的提升极为明显，推荐创建
    # 格式：create_node('person', 'name')
    def create_index(self, index_label, index_property):
        cql = f"create index for (n:{index_label}) on (n.{index_property})"
        self.graph.run(cql)

    # 3.创建一个或多个node节点，返回创建的node的<id>
    # 格式：create_node('person', {'name': 'shuo', 'age': 18})
    def create_node(self, node_label, node_dict):
        node = Node(node_label, **node_dict)
        self.graph.create(node)
        node1 = str(node)
        node_id_list = []
        list1 = re.findall(r'_.*?:', node1)
        for i in list1:
            node_id_list.append(i[1:-1])
        return node_id_list

    # 4.创建单个关系
    # 格式: create_one_relationship('person',{'name':'shuo'},'person',{'name':'tom'},'朋友')  1
    def create_one_relationship(self, f1_label, f1_detail, f2_label, f2_detail, relation_name):
        f1_node = self.get_one_node_position(f1_label, f1_detail)
        f2_node = self.get_one_node_position(f2_label, f2_detail)
        rel = Relationship(f2_node, relation_name, f1_node)
        self.graph.create(rel)

    # 5.创建并添加一或多条关系数据     注意：这不是在原有的关系中添加数据，而是”创建“关系写入数据
    # 格式：add_relationship_info('person', {'name': 'shuo'}, 'person', {'name': 'Tom'}, "friend", {'create_time: '2022'})
    def add_relationship_info(self, f1_label, f1_detail, f2_label, f2_detail, relation_name, info):
        node_point1 = self.get_one_node_position(f1_label, f1_detail)
        node_point2 = self.get_one_node_position(f2_label, f2_detail)
        node1_vs_node2 = Relationship(node_point1, relation_name, node_point2, **info)
        self.graph.merge(node1_vs_node2)

    # 6.拿到单个node的信息未解码版
    # 格式：get_one_node_position('person', {'name': 'shuo'})
    def get_one_node_position(self, node_label, node_dict):
        node_data = NodeMatcher(self.graph)
        node_point = node_data.match(node_label, **node_dict).first()
        return node_point

    # 7.拿到单个node的信息字典版
    # 格式：get_one_node_dict('person', {name: 'shuo'})
    def get_one_node_dict(self, node_label, node_dict):
        f1_node = self.get_one_node_position(node_label, node_dict)
        return dict(f1_node)



    # 8.拿到一个node的所有关系，并返回一个list
    # 格式：get_one_node_relationship('person', {'name': 'shuo'})
    def get_one_node_relationship(self, node_label, node_dict):
        all_relation = RelationshipMatcher(self.graph)
        node_point = self.get_one_node_position(node_label, node_dict)
        rel = list(all_relation.match((node_point,)))
        return rel

    # 9.拿到跟两个节点都有关系的节点
    def get_several_node_relationship(self,node_label, node_dict, node_dict2):
        f1=[]
        f2=[]
        f3_node=[]
        f1_node = self.get_one_node_relationship(node_label, node_dict)
        f2_node = self.get_one_node_relationship(node_label, node_dict2)

        # f3_node = self.get_one_node_position(node_label3, node_dict3)
        for item in f1_node:
            item=str(item)
            id = item.split('->(_')
            f1.append(id[1][0:-1])
        for item in f2_node:
            item=str(item)
            id = item.split('->(_')
            f2.append(id[1][0:-1])
        f_node=list(set(f1).intersection(set(f2)))
        return f_node


    # 10.添加一条node节点数据
    # 格式：add_one_node_info('person', {'name': 'shuo'}， {'gender': 'man'})
    def add_one_node_info(self, node_label, node_name, info):
        node_point = self.get_one_node_position(node_label, node_name)
        self.graph.push(node_point.update(info))

    # 11.更改一条node节点数据,也可以用来添加多个节点数据
    # 格式：change_one_node_info('person', {'name': 'shuo'}, {'age': 21, 'gender': 'man'})
    def change_one_node_info(self, node_label, node_name, info_dict):
        node_point = self.get_one_node_position(node_label, node_name)
        for i, j in info_dict.items():
            node_point[i] = j
        self.graph.push(node_point)

    # 12.删除一个node的所有关系
    # 格式: del_all_relationship_of_a_node('person', {'name': 'shuo'})
    def del_all_relationship_of_a_node(self, node_label, node_name):
        key = list(node_name.keys())[0]
        value = list(node_name.values())[0]
        value = "'" + value + "'"
        self.graph.run("MATCH s=((n:" + node_label + '{' + key + ':' + value + '}' + ")-[ss]-()) delete ss")

    # 13.删除一个node的一个关系
    # 格式: del_one_relationship_of_a_node('person', {'name': 'shuo'}, 'friend')
    def del_one_relationship_of_a_node(self, node_label, node_name, relation_name):
        key = list(node_name.keys())[0]
        value = list(node_name.values())[0]
        value = "'" + value + "'"
        self.graph.run(
            "MATCH s=((n:" + node_label + '{' + key + ':' + value + '}' + ")-[ss:" + relation_name + "]-()) delete ss")

    # 14.删除单个的node以及其关系
    # 格式：del_one_node('person', {'name': 'shuo'})
    def del_one_node(self, node_label, node_name):
        key = list(node_name.keys())[0]
        value = list(node_name.values())[0]
        value = "'" + value + "'"
        self.graph.run('match (n:' + node_label + '{' + key + ':' + value + '}' + ') detach delete n')

    # 15.根据id删除节点(注意，只能删除没有关系的节点)
    def del_one_node_by_id(self, id_num):
        self.graph.run(f'MATCH (n) WHERE id(n) = {id_num} DELETE n')

    # 16.删除当前库中所有的数据，跑路需谨慎，跑路有风险
    def del_all(self):
        self.graph.delete_all()

    # 17.删除相同label的所有node
    # 格式：del_all_node_of_same_label('person')
    def del_all_node_of_same_label(self, node_label):
        cql = f"match (n:{node_label}) delete n"
        self.graph.run(cql)

    # 18.删除相同label的所有关系
    # del_all_relationship_of_same_label('friend')
    def del_all_relationship_of_same_label(self, relation_label):
        cql = f"MATCH (n)-[k:{relation_label}]->(f) Delete k"
        self.graph.run(cql)

    # 19.执行"任何"cql代码       所有的cql代码都可以执行
    def run_any_cql_code(self, sentence):
        self.graph.run(sentence)

    # 功能测试区域---------------------------------------------------------------------------------------------------------
    # 为了在基于亿为单位的数据中根据id快速添加关系，以下函数皆可使用 注意：这不是在原有的关系中添加数据，而是”创建“关系写入数据
    # 格式：create_add_relationship_info('person', {'name': 'shuo'}, 'person', {'name': 'Tom'}, "friend", {'create_time: '2022'})
    def create_add_relationship_info(self, f1_label, f1_detail, f2_label, f2_detail, relation_name, info=None):
        key1 = list(f1_detail.keys())[0]
        value1 = list(f1_detail.values())[0]
        value1 = "'" + value1 + "'"
        key2 = list(f2_detail.keys())[0]
        value2 = list(f2_detail.values())[0]
        value2 = "'" + value2 + "'"
        cql_match_string = "MATCH (a:" + f1_label + "{" + key1 + ": " + value1 + "}), (b:" + f2_label + "{" + key2 + ": " + value2 + "}) "
        if info is None:
            cql_create_string = "CREATE (a)-[r:" + relation_name + "]->(b)"
        else:
            info_string = ', '.join(f'{i}: "{j}"' for i, j in info.items())
            info_string = "{" + info_string + "}"
            cql_create_string = "CREATE (a)-[r:" + relation_name + info_string + "]->(b)"
        cql_string = cql_match_string + cql_create_string
        self.graph.run(cql_string)

    def create_relationship_by_property_and_id(self, f1_label, f1_detail, f2_id, relation_name, info=None):
        key1 = list(f1_detail.keys())[0]
        value1 = list(f1_detail.values())[0]
        value1 = "'" + value1 + "'"
        if info is None:
            cql_string = "match (a:" + f1_label + "),(b) where a." + key1 + "=" + value1 + " and id(b)=" + str(
                f2_id) + " CREATE (a)-[r:" + relation_name + "]->(b)"
        else:
            info_string = ', '.join(f'{i}: "{j}"' for i, j in info.items())
            info_string = "{" + info_string + "}"
            cql_string = "match (a:" + f1_label + "),(b) where a." + key1 + "=" + value1 + " and id(b)=" + str(
                f2_id) + " CREATE (a)-[r:" + relation_name + info_string + "]->(b)"
        self.graph.run(cql_string)

    def create_relationship_by_id_and_property(self, f1_id, f2_label, f2_detail, relation_name, info=None):
        key2 = list(f2_detail.keys())[0]
        value2 = list(f2_detail.values())[0]
        value2 = "'" + value2 + "'"
        if info is None:
            cql_string = "match (a),(b:" + f2_label + ") where id(a)=" + str(
                f1_id) + " and b." + key2 + "=" + value2 + " CREATE (a)-[r:" + relation_name + "]->(b)"
        else:
            info_string = ', '.join(f'{i}: "{j}"' for i, j in info.items())
            info_string = "{" + info_string + "}"
            cql_string = "match (a),(b:" + f2_label + ") where id(a)=" + str(
                f1_id) + " and b." + key2 + "=" + value2 + " CREATE (a)-[r:" + relation_name + info_string + "]->(b)"
        self.graph.run(cql_string)

    def create_relationship_by_id_and_id(self, f1_id, f2_id, relation_name, info=None):
        if info is None:
            cql_string = "match (a),(b) where id(a)=" + str(f1_id) + " and id(b)=" + str(
                f2_id) + " CREATE (a)-[r:" + relation_name + "]->(b)"
        else:
            info_string = ', '.join(f'{i}: "{j}"' for i, j in info.items())
            info_string = "{" + info_string + "}"
            cql_string = "match (a),(b) where id(a)=" + str(f1_id) + " and id(b)=" + str(
                f2_id) + " CREATE (a)-[r:" + relation_name + info_string + "]->(b)"
        self.graph.run(cql_string)