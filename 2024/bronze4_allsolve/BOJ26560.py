T = int(input())

for t in range(T) :
    st = str(input())
    if st[-1] != '.' : 
        st += '.'
    print(st)