
N = int(input())

for n in range(N):
    a, b, c, d = map(int, input().split())

    aa = a * b
    cc = c * d
    if(aa > cc) :
        print("TelecomParisTech")
    elif(aa < cc) :
        print("Eurecom")
    else :
        print("Tie")
