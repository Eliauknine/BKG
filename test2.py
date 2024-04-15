file = open('D:/yan/python_project/CCFinderSW-1.0/bin/outputfile_ccfsw.txt', 'r', encoding='utf-8')

file_numberB=['9','12']
count=0
for item in file:
    if '#source_files' in item:
        break

for item in file:
    item=item.split('	')
    if item[0] in file_numberB:
        url = item[3].split('code')[1][:-6]
        print(type(url))