#include <iostream>
#include <vector>
#include <queue>

using namespace std;


int main() {
    int move[8][2] = { {1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1} };
    vector<vector<int>> map(8, vector<int>(8, -1));

    int r, c, ed_r, ed_c;
    cin >> r >> c;
    cin >> ed_r >> ed_c;
    r -= 1;
    c -= 1;
    ed_r -= 1;
    ed_c -= 1;

    queue<pair<int, int>> que;
    map[r][c] = 0;

    if(r == ed_r && c == ed_c) {
        cout << 0;
        return 0;
    }

    que.push(make_pair(r, c));
    while(true) {
        pair<int, int> now = que.front();
        que.pop();

        for(int i = 0; i < 8; i++) {
            int nr = now.first + move[i][0];
            int nc = now.second + move[i][1];

            if(nr < 0 || nr >= 8 || nc < 0 || nc >= 8) continue;
            if(map[nr][nc] != -1) continue;

            map[nr][nc] = map[now.first][now.second] + 1;

            if(nr == ed_r && nc == ed_c) {
                cout << map[nr][nc];
                return 0;
            }
            que.push(make_pair(nr, nc));
        }

    }
}