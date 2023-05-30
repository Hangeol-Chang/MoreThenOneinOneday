
s1, s2 = map(str, input().split(" "))

a = list(map(int, s1))
b = list(map(int, s2))

print(sum(a) * sum(b))