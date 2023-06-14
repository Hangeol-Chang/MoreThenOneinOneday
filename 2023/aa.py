import sys
tok = iter(open('aa.txt', 'r').read().splitlines())

try:
    # s = next(tok)
    while True:
        print(next(tok))
except:
    print("err")
    pass