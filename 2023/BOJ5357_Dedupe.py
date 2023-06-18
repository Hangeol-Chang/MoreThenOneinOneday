
N = int(input())
for i in range(N):
    inp = str(input())

    length = len(inp)
    ans = ''
    ch = 'a'
    for i in range(length) :
        if ch != inp[i] :
            ans += inp[i]
            ch = inp[i]

    print(ans)