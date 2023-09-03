#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct loc {
    int r, c;
    int cost;

    loc(int rin, int cin, int c) : r(rin), c(cin), cost(c) {}
};

int main() {
    int R, C;
    cin >> R >> C;
    
    vector<vector<int>> map(R, vector<int>(C, 0));
    vector<vector<int>> vis(R, vector<int>(C, -1));

    int sr, sc;
    for(int r = 0; r < R; r++)
        for(int c = 0; c < C; c++) {
            cin >> map[r][c];
            if(map[r][c] == 2) {
                sr = r;
                sc = c;
            }
            else if(map[r][c] == 0) {
                vis[r][c] = 0;
            }
        }

    queue<loc> que;
    que.push(loc(sr, sc, 0));

    vector<vector<int>> drdc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while(!que.empty()) {
        loc now = que.front();
        que.pop();

        if(vis[now.r][now.c] != -1) continue;
        vis[now.r][now.c] = now.cost;


        for(vector<vector<int>>::iterator drc = drdc.begin(); drc != drdc.end(); drc++) {
            int nr = now.r + (*drc)[0];
            int nc = now.c + (*drc)[1];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C || vis[nr][nc] != -1) continue;
            
            que.push(loc(nr, nc, now.cost + 1));
        }
    }

    for(vector<vector<int>>::iterator it = vis.begin(); it != vis.end(); it++) {
        for(vector<int>::iterator it2 = it->begin(); it2 != it->end(); it2++) {
            cout << *it2 << " ";
        }
        cout << "\n";
    }
}