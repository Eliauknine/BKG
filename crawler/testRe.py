import csv


file2=open("bugrdf/bug2.csv", 'w', newline='', encoding='utf-8', errors='ignore')
writer = csv.writer(file2)
with open("bugrdf/bug2.csv", 'r', encoding='utf-8', errors='ignore') as file:
    reader = csv.reader(file)
    for item in reader:
        if( item[2]=='has_buggycode' ):
            if(item[0]==''):
                item[0]='null'
            if (item[1] == ''):
                item[1] = 'null'
        if (item[2] == 'has_fixedcode'):
            if (item[0] == ''):
                item[0] = 'null'
            if (item[1] == ''):
                item[1] = 'null'
        writer.writerows([item])

file.close()
file2.close