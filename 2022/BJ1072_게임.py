from decimal import Decimal

a, b = map(Decimal, input().split())
p = b*100//a + 1
# print(p)

if p > 99 :
    print(-1)
else :
    p /= 100
    # print(p)

    quo = (a * p - b) // (1 - p)
    mod = (a * p - b) /  (1 - p) - quo
    # print(quo, mod)
    
    ans = int(quo) 
    ans += 1 if mod > 0 else 0
    print(ans)