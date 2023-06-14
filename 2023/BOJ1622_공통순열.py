def getbig(a, b):
    if a[0] > b[0] :
        return a
    elif a[0] < b[0] :
        return b
    else :
        # 사전순으로 앞서는 것을 return
        if a[1] == '' :
            return b
        if b[1] == '' :
            return a
        
        if a[1] < b[1] :
            return a
        else :
            return b

for p in range(3):
    a = str(input())
    b = str(input())

    # 2차원 배열에 넣을거임.
    lena = len(a)
    lenb = len(b)
    board = [[[0, ''] for j in range(lena + 1)] for i in range(lenb + 1)]
    
    for i in range(1, lena + 1) :
        for j in range(1, lenb + 1) :
            print(i, j)
            bef = getbig(board[j-1][i], board[j][i-1])
            bef = getbig(bef, board[j-1][i-1])

            if a[i - 1] == b[j - 1] :
                board[j][i] = [bef[0] + 1, bef[1] + a[i - 1]]
            
            else :
                board[j][i] = [bef[0], bef[1]]

    for i in range(0, lena + 1) :
        for j in range(0, lenb + 1) :
            print(board[j][i], end=' ')
        print()