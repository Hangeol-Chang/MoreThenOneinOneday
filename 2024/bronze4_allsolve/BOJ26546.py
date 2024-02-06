t = int(input())

for i in range(t) :
    line = list(map(str, input().split()))
    print(line[0][:int(line[1])], end='')
    print(line[0][int(line[2]):])