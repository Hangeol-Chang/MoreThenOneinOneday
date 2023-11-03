a = int(input())
b = int(input())

c = b - a
ans = 500 if c >= 31 else 270 if c >= 21 else 100 if c >= 1 else 0
if ans :
    print(f'You are speeding and your fine is ${ans}.')
else :
    print('Congratulations, you are within the speed limit!')