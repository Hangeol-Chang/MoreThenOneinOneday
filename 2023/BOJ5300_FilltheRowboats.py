N = int(input())

for i in range(1, N, 1):
    print(i, end=" ")
    if i % 6 == 0 :
        print("Go! ", end='')

print(N, "Go!")