#include<iostream>

using namespace std;

int main() {
    int R, C;
    cin >> R >> C;
    
    // 0이 경비원이 필요한 상태
    bool r[R];
    fill_n(r, R, 0);
    bool c[C];
    fill_n(c, C, 0);
    
    for(int i = 0; i < R; i++) {
        string inp;
        cin >> inp;
        
        for(int j = 0; j < C; j++) {
            if(inp[j] == 'X') {
                r[i] = 1;
                c[j] = 1;
            }
        }
    }
    int rr = 0;
    int cc = 0;
    
   for(bool b : r)
       if(!b)
           rr++;
    
   for(bool b : c)
       if(!b)
           cc++;
    
    cout << max(cc, rr);
    
}