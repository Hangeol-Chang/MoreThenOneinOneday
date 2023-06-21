
ss = str(input())

nums = []

a = -1
for c in ss:
    cc = int(c)
    if a != cc :
        nums.append(cc)
        a = cc

print(int(len(nums) / 2))