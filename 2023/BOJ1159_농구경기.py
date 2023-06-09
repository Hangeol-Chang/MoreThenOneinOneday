
N = int(input())

n = ord('a')
names = [0 for i in range(26)]
for i in range(N):
    name = str(input())
    names[ord(name[0]) - n] += 1

ans = ''
for i in range(26):
    if names[i] >= 5:
        ans += chr(i + n)

if not ans:
    print("PREDAJA")
else :
    print(ans)