#include<iostream>

using namespace std;

struct loc {
    int r, c;
    loc(int rin, int cin) : r(rin), c(cin) {};
};

int main() {
    string a, b;
    int N;
    cin >> a >> b >> N;
    
    loc king(a[0] - 'A' + 1, a[1] - '0');
    loc rock(b[0] - 'A' + 1, b[1] - '0');

    for(int i = 0; i < N; i++) {
        string order;
        cin >> order;

        int dr = 0, dc = 0;
        for(char c : order) {
            switch(c) {
                case 'R' :
                    dr = 1;
                    break;
                case 'L' :
                    dr = -1;
                    break;
                case 'B' :
                    dc = -1;
                    break;
                case 'T' :
                    dc = +1;
                    break;
            }
        }
        int kr = king.r + dr;
        int kc = king.c + dc;
        // 범위 밖이면 밖으로 이동 안하고 다음꺼.
        if(kr < 1 || kr > 8 || kc < 1 || kc > 8) continue;

        // 돌과 겹치는지 확인.
        if(rock.r == kr && rock.c == kc) {
            int rr = rock.r + dr;
            int rc = rock.c + dc;

            if(rr < 1 || rr > 8 || rc < 1 || rc > 8) continue;

            rock.r = rr; 
            rock.c = rc;
        }
        
        king.r = kr;
        king.c = kc;
    }
    printf("%c%d\n", king.r - 1 + 'A', king.c);
    printf("%c%d",   rock.r - 1 + 'A', rock.c);
}