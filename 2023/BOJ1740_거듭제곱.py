
def pow(x, y) :
    ret = 1
    while y > 0 :
        ret *= x
        y -= 1
    return ret

def getWltn(n):
    num = 1
    i = 0
    while num <= n :
        i += 1
        num *= 2
    return i, int(n - num/2)

if __name__ == "__main__" :
    N = int(input())

    zari, loc = getWltn(N)

    ans = 0
    for i in range(zari) :
        if N & (1 << i) > 0:
            ans += pow(3, i)

    print(ans)