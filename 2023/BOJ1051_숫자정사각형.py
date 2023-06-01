R, C = map(int, input().split())

arr = []
for r in range(R) :
    row = str(input())
    spl_row = []
    for c in row :
        spl_row.append(int(c))
    arr.append(spl_row)

# 입력 완료.

ans = 1
for r, row in enumerate(arr) :
    for c, val in enumerate(row) :
        maxL = min(R - r, C - c)

        for i in range(1, maxL) :
            cmp1 = arr[r + i][c + i]
            cmp2 = arr[r][c + i]
            cmp3 = arr[r + i][c]

            if val == cmp1 and val == cmp2 and val == cmp3 :
                ans = max(ans, i + 1)
print(ans ** 2)