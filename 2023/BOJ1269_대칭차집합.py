N, M = map(int, input().split())

a = set(map(int, input().split()))
b = set(map(int, input().split()))

s = (len(a & b))
print(len(a) + len(b) - 2*s)