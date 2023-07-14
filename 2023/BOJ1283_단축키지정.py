

N = int(input())

res = []
keys = [0 for i in range(26)]
idf = ord('A')

for t in range(N) :
    inp = str(input())
    
    idxR = -1
    l = len(inp)
    
    checkpoints = [0]
    
    # 체크포인트 찾기.
    for i in range(l):
        if(inp[i] == ' '):
            checkpoints.append(i + 1)

    # 체크포인트만 판단.
    for i in checkpoints:
        idx = (ord(inp[i]) - idf)
        idx = idx - 32 if idx > 26 else idx

        if(keys[idx] == 0) :
            keys[idx] = 1
            idxR = i
            break

    # 나머지 판단
    if idxR == -1:
        for i in range(l):
            idx = ord(inp[i]) - idf
            idx = idx - 32 if idx > 26 else idx
            if i in checkpoints or idx < 0 :
                continue

            if(keys[idx] == 0) :
                keys[idx % 26] = 1
                idxR = i
                break

    if(idxR != -1):
        fr = inp[:idxR] if idxR >= 0 else ''
        ed = inp[idxR + 1:] if idxR + 1 <  l else ''
        
        inp = fr + '[' + inp[idxR] + ']' + ed
    res.append(inp)

for s in res:
    print(s)