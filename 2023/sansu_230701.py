
selected = [0, 0, 0, 0, 0, 0, 0]
lined = [0, 0, 0, 0, 0, 0, 0]

global anscount
anscount = 0

def checkValid():
    global anscount
    # print(lined)
    print(lined, end = " ")

    for i in range(1, 6, 1):
        if lined[i] == 1 :
            if ( lined[i-1] == 2 or lined[i-1] == 3) or ( lined[i+1] == 2 or lined[i+1] == 3) :
                print("fail 1")
                return
        elif lined[i] == 4:
            if lined[i-1] == 5 or lined[i+1] == 5:
                print("fail 4")
                return

    print("pass")
    anscount += 1

def select(loc):
    if(loc == 6):
        checkValid()
        return
    
    for i in range(1, 6, 1):
        if not selected[i] :
            selected[i] = 1

            lined[loc] = i
            select(loc + 1)
            
            selected[i] = 0


if __name__ == "__main__" :

    select(1)
    print(anscount)