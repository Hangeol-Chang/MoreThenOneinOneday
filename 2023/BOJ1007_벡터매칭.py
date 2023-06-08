coordis = []
N = 0

def run(used, idx, count):
    global inited
    global ans
    
    if idx == N :
        if count == N/2 :
            # 더하기
            x = 0
            y = 0
            
            for i in range(N):
                if used[i]:
                    x += coordis[i][0]
                    y += coordis[i][1]
                else :
                    x -= coordis[i][0]
                    y -= coordis[i][1]
            
            ansCandi = (x**2 + y **2)**(1/2)
            # print(ansCandi)

            if not inited:
                inited = True
                ans = ansCandi
            else :
                ans = min(ansCandi, ans)
        else:
            return

    for i in range(idx, N):
        used[i] = 1
        run(used, i + 1, count + 1)
        used[i] = 0


T = int(input())
for i in range(T):
    N = int(input())

    # 좌표 초기화
    coordis = []
    inited = False
    ans = 0
    used = [0 for i in range(N)]
    for i in range(N) :
        coordi = list(map(int, input().split()))
        coordis.append(coordi)
    # 입력 완료

    run(used, 0, 0)
    print(ans)