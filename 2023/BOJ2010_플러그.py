import sys

a = int(input())

sum = 1
for i in range(1, a+1) :
    num = int( sys.stdin.readline().rstrip() )
    sum += num - 1

print(sum)