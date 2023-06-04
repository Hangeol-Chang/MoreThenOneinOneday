
n = int(input())

data = []
for i in range(n) :
    inp = str(input())

    dup = False
    for d in data:
        if len(d) != len(inp) * 2 :
            continue
        
        if inp in d:
            dup = True
            break
            
    if not dup:
        data.append(inp + inp)

print(len(data))