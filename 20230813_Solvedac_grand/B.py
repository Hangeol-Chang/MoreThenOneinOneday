a = str(input())
b = str(input())
c = str(input())

ans = 0

if c.isdigit() :
    ans = int(c) + 1
elif b.isdigit() :
    ans = int(b) + 2
elif a.isdigit() :
    ans = int(a) + 3

output = ''

if ans % 3 == 0 :
    output += 'Fizz'
if ans % 5 == 0 :
    output += 'Buzz'

if output == '' :
    print(ans)
else :
    print(output)