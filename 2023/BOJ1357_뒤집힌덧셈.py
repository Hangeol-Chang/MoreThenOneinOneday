
str_x, str_y = map(str, input().split())

def calc(str_a):
    a = 0
    po = 1
    for c in str_a:
        a += int(c) * po
        po *= 10
    return a


x = calc(str_x)
y = calc(str_y)

print(calc(str(x + y)))