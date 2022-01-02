a = int(input())
sosu = True

for i in range (2, a) :
    if( a % i == 0 ) :
        sosu = False
        break

if sosu :
    print("소수입니다.")
else :
    print("소수가 아닙니다.")