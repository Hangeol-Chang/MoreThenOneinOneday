
s = set()
nums = []

n = int(input())

for i in range(n) :
    nums.append(str(input()))

numLen = len(nums[0])

codeLen = 0
run = True
while(run) :
    codeLen += 1
    s.clear()

    for i, num in enumerate(nums):
        s.add(num[-1 * codeLen:])
        if len(s) != i+1 : 
            break

    if len(s) == len(nums) :
        break

print(codeLen)