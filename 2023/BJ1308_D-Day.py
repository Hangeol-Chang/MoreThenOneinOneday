days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

# 문제가 너무 지저분함.
def morethan1000y(d1, d2):
    if d1[0] + 1000 > d2[0] : return False
    elif d1[0] + 1000 < d2[0] : return True
    else :
        if d1[1] > d2[1] : return False
        elif d1[1] < d2[1] : return True
        else:
            if d1[2] > d2[2] : return False
            else : return True


def isLeap(year):
    if year % 400 == 0:
        return 1

    if year % 4 == 0:
        if year % 100 == 0:
            return 0
        else :
            return 1
    return 0

st = list(map(int, input().split()))
ed = list(map(int, input().split()))

# 천년 이상 지속시
if(morethan1000y(st, ed)) :
    print("gg")
    exit()

sty = st[0]
edy = ed[0]

ans = 0

if morethan1000y(st, ed):
    ans = -1
else :
    # 올해 안에 끝나는거
    if st[0] == ed[0] :
        # 이번달 안에 끝나는거
        if st[1] == ed[1] :
            ans = ed[2] - st[2]

        # 올해 안에 끝나는거
        else :
            # 이번달 남은 일수.
            totday = days[st[1]] - st[2]
            if st[1] == 2 : totday += isLeap(st[0]) 

            # 중간 달 일수.
            for m in range(st[1] + 1, ed[1], 1) :
                totday += days[m]
                if m == 2 : totday += isLeap(st[0])

            # 마지막달 일수.
            totday += ed[2]
            ans = totday

    # 1년 이상.
    else :
        # 이번년도 끝까지 더하기.   
            # 이번월 남은일수.
        totday = days[st[1]] - st[2]
        if st[1] == 2 : totday += isLeap(st[0]) 

            # 이번년도 남은일수. 
        for m in range(st[1] + 1, 13, 1) :
            totday += days[m]
            if m == 2 : totday += isLeap(st[0])

        # 중간년들
        for y in range(st[0] + 1, edy, 1):
            totday += 365 + isLeap(y)
        
        # 마지막년도
        for m in range(1, ed[1], 1):
            totday += days[m ]
            if m == 2:
                totday += isLeap(ed[0])
        totday += ed[2]
        ans = totday

# 답 출력부.
if ans > 0:
    print("D-" + str(ans))
else :
    print("gg")