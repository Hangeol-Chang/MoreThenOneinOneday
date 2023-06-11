N, M = map(int, input().split())

# 100/100따리 행렬
m = [[0 for j in range(101)] for i in range(101)]
for i in range(N):
    x1, y1, x2, y2 = map(int, input().split())

    for x in range(x1, x2+1):
        for y in range(y1, y2+1):
            m[x][y] += 1


ans = 0
for x in range(1, 101):
    for y in range(1, 101):
        if m[x][y] > M :
            ans += 1

print(ans)     
    