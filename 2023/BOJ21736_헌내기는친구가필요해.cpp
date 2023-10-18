#include <iostream>
#include <vector>
#include <queue>

struct loc {
    int r, c;
    loc(int rin, int cin) : r(rin), c(cin) {};
};

using namespace std;

int main() {
    int R, C; cin >> R >> C;
    
    vector<vector<int>> map(R, vector<int>(C, 0));

    int sr, sc;

    for(int r = 0; r < R; r++) {
        string tmp;
        cin >> tmp;

        for(int c = 0; c < C; c++) {
            switch(tmp[c]) {
                case 'O' :
                    map[r][c] = 0;
                    break;
                case 'I' :
                    map[r][c] = 2;
                    sr = r; sc = c;
                    break;
                case 'X' :
                    map[r][c] = 9;
                    break;
                case 'P' :
                    map[r][c] = 1;
                    break;
            }
        }
    }
    queue<loc> que;
    que.push(loc(sr, sc));    

    int f = 0;

    vector<vector<int>> drdc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while(!que.empty()) {
        loc now = que.front();
        que.pop();

        for(vector<vector<int>>::iterator dd = drdc.begin(); dd != drdc.end(); dd++) {
            int nr = now.r + (*dd)[0];
            int nc = now.c + (*dd)[1];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(map[nr][nc] <= 1) {
                if(map[nr][nc] == 1)  ++f;
                
                map[nr][nc] = 2;
                que.push(loc(nr, nc));
            }
        }
    }

    if(f) cout << f;
    else cout << "TT";
}