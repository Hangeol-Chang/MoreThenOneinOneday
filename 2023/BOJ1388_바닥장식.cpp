#include <iostream>
#include <vector>

using namespace std;


int main() {
    int R, C;
    cin >> R >> C;

    vector<vector<int>> map(R, vector<int>(C, 0));

    char line[C];
    for(int r = 0; r < R; r++) {
        cin >> line;
        for(int c = 0; c < C; c++) {
            // - > 0 > 이미 0이라서 안건드려도 됨.
            // | > 1
            if(line[c] == '|') map[r][c] = 1;
        }
    }
    // 입력 완료 .

    // 전체 순회하면서 
    int tileCount = 0;
    for(int r = 0; r < R; r++) {
        for(int c = 0; c < C; c++) {
            if(map[r][c] == 0) {
                tileCount++;
                // c방향 이동.
                int nc = c;
                while (nc < C && map[r][nc] == 0) {
                    map[r][nc++] = 2;
                }
            }
            else if(map[r][c] == 1) {
                tileCount++;
                // r방향 이동
                int nr = r;
                while(nr < R && map[nr][c] == 1) {
                    map[nr++][c] = 2;
                }
            }
        }
    }

    cout << tileCount;
}