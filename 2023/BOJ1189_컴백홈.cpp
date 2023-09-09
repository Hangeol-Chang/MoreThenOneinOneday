#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> map;
vector<vector<int>> drdc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

int R, C, cost;
int ans;

void run(int r, int c, int time) {
    if(r == 0 && c == C-1) {
        if(time == cost) ans++;
        return;
    }

    for(vector<vector<int>>::iterator dd = drdc.begin(); dd != drdc.end(); dd++) {
        int nr = r + (*dd)[0];
        int nc = c + (*dd)[1];

        if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
        if(map[nr][nc] != 0) continue;

        map[nr][nc] = 1;
        run(nr, nc, time + 1);
        map[nr][nc] = 0;
    }
}


int main() {
    cin >> R >> C >> cost;

    map = vector<vector<int>>(R, vector<int>(C, 0));

    for(int r = 0; r < R; r++) {
        string inp;
        cin >> inp;

        for(int c = 0; c < C; c++)
            if(inp[c] == 'T') 
                map[r][c] = -1;
            
    }

    map[R-1][0] = 1;
    run(R-1, 0, 1);
    cout << ans;
}