
while True :
    n = int(input())
    if n == 0 :
        break

    for i in range(1, n+1) :
        for j in range(1, i+1) :
            print('*', end='')
        print()