d = {
    'Never gonna give you up',
    'Never gonna let you down',
    'Never gonna run around and desert you',
    'Never gonna make you cry',
    'Never gonna say goodbye',
    'Never gonna tell a lie and hurt you',
    'Never gonna stop'
}

n = int(input())

ans = True 
for i in range(n) :
    aa = str(input())
    if aa not in d :
        ans = False

if not ans : print("Yes")
else : print("No")