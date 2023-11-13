
qnswk = 0
qnsah = 1
for i in range(1, 12, 1) :
    qnsah *= i

for i in range(1, 12, 1) :
    pm = 1 if i % 2 == 1 else -1
    qnswk += pm * qnsah // i

# print(qnswk, qnsah)

div = 2
while div < qnsah :
    if qnswk % div == 0 and qnsah % div == 0 :
        qnswk //= div
        qnsah //= div
    else :
        div += 1

print(qnswk, qnsah)