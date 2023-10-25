
n = int(input())

ans = ''
while n >= 5 :
    n -= 5
    ans += 'V'

while n > 0 :
    n -= 1
    ans += 'I'

print(ans)