a, b = input().split()
lena = len(a)
lenb = len(b)

max = lenb

for i in range(0, lenb - lena + 1) :
    cmpval = 0
    for j in range(lena) :
        if(a[j] != b[i + j]) :
            cmpval += 1

    max = max if max < cmpval else cmpval

print(max)
