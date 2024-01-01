
d = {
    'CU'    : 'see you',
    ':-)'   : 'I’m happy',
    ':-('   : 'I’m unhappy',
    ';-)'   : 'wink',
    ':-p'   : 'stick out my tongue',
    '(~.~)' : 'sleepy',
    'TA'    : 'totally awesome',
    'CCC'   : 'Canadian Computing Competition',
    'CUZ'   : 'because',
    'TY'    : 'thank-you',
    'YW'    : 'you’re welcome',
    'TTYL'  : 'talk to you later'
}

while True :
    s = str(input())
    try :
        print(d[s])
    except :
        print(s)
    
    if s == 'TTYL' :
        break