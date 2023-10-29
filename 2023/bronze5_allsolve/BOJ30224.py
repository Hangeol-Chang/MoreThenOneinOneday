num = int(input())
strnum = str(num)

ans = 0
if '7' in strnum : ans += 2
if num % 7 == 0 : ans += 1
print(ans)