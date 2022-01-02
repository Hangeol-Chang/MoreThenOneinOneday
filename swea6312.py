def function(*T) :
    a=1
    for i in T:
        if ( type(i) == 'int') :
            a *= i
        else : 
            return "에러발생"

    return a

print(function(1,2,'4',3))