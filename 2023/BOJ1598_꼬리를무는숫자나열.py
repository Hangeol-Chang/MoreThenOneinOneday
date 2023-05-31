
num1, num2 = map(int, input().split())

num1 -= 1
num2 -= 1

c1 = int(num1 / 4)
r1 = num1 % 4

c2 = int(num2 / 4)
r2 = num2 % 4

print(abs(c2 - c1) + abs(r2 - r1))