target, b = map(int, input().split())

cnt = 0
st = -1

for i in range(b, 101) :
    even = False

    if(i%2 == 0) :
        even = True

    mid = target//i

    jud = 0
    if even :
        jud = i//2 * (mid * 2 + 1)
    else :
        jud = i * mid

    # print(i, jud, target)
    if jud == target :
        if even :
            st = target//i - i//2 + 1
        else :
            st = target//i - i//2 

        if st < 0 :
            print(-1)
            quit()
        break

if st < 0 :
    print(-1)
    quit()

for j in range(i) :
    print(st + j, end = ' ')

    