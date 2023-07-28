
N = int(input())
price = list(map(int, input().split()))
wallet = int(input())

maxRoomNum = ['' for i in range(51)]

# 1코스트부터 진행.
for c in range(1, wallet + 1) :
    for (num, cost) in enumerate(price):
        # 현재 가진 코스트 c
        # 현재 번호 num, num의 가격 cost
        
        for i in range(0, c - cost + 1) :
            now = str(num) + maxRoomNum[i] if num != 0 else maxRoomNum[i] + str(num)
            # print('    ', i, cost, num, now)
            if(maxRoomNum[c] == '') :
                maxRoomNum[c] = now
            else :
                maxRoomNum[c] = now if int(now) >= int(maxRoomNum[c]) else maxRoomNum[c]

    # print(c, maxRoomNum[c])

print(int(maxRoomNum[wallet]))