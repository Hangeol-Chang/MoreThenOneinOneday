import sys
tok = iter(open('aa.txt', 'r').read().splitlines())
# tok  = iter(sys.stdin.read().splitlines())

try:
    while True:
        # a = sorted(next(tok))
        # try :
        #     b = sorted(next(tok))
        # except:
        #     b = []
            
        # # print("?", a, b)
        # # a = sorted(str(input()))
        # # b = sorted(str(input()))

        # lena = len(a)
        # lenb = len(b)

        # pa = 0
        # pb = 0

        # ans = ''
        # # 어느 한쪽이 끝에 도달할때까지.
        # while( pa != lena and pb != lenb ) :
        #     if(a[pa] == b[pb]) :
        #         ans += a[pa]
        #         pa += 1
        #         pb += 1

        #     while(pa < lena and a[pa] < b[pb]) : pa += 1
        #     if pa == lena : break
        #     while(pb < lenb and a[pa] > b[pb]) : pb += 1


        # print(ans)

        a = next(tok)
        b = next(tok)
        ans = ''

        for aa in a :
            if aa in b :
                ans += aa
                b = b.replace(aa, '', 1)
        
        print(''.join(sorted(ans)))

except:
    pass