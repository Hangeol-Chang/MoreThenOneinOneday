# add hook

T = int(input())

# 0이 3개 이상 있으면 지우기
# 1도 3개 이상 있으면 지우기

# 10 > A
# 01 > B

for t in range(T) :
    inp = str(input())

    word = ''

    bef = '2'
    bbef = '2'

    # 0압축
    for c in inp :    
        if c == bef and c == bbef and c == '0':
            pass
        else :
            word += c
            bbef = bef
            bef = c
    
    # print(word, end = ' ')
    
    word = word.replace('1001', 'A')
    word = word.replace('01', 'B')
    
    len1 = len(word)
    len2 = 0

    # 1압축
    while len1 != len2 :
        word = word.replace('A1', 'A')

        len2 = len1
        len1 = len(word)


    # print(word, end=' ')

    if '1' in word or '0' in word :
        print('NO')
    else :
        print('YES')



# 0111001 > NO