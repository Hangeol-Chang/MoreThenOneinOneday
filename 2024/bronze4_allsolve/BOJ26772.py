n = int(input())

map = [
' @@@   @@@ ',
'@   @ @   @',
'@    @    @',
'@         @',
' @       @ ',
'  @     @  ',
'   @   @   ',
'    @ @    ',
'     @     ']

for line in map :
    for i in range(n) :
        print(line, end = '\n' if i == n-1 else ' ')