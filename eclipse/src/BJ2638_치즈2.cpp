#include <vector>
#include <algorithm>
#include <queue>
#include <iostream>

using namespace std;

int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

int totCount = 0;
int totTime = 0;

int main() {
    
    // 입력받아 맵 만들기.
    int R, C;
    cin >> R >> C;

    vector<vector<int>> map(R+2);
    for(int i = 0; i < R+2; i++) map[i].assign(C+2, -1);

    for(int r = 1; r <= R; r++) {
        for(int c = 1; c <= C; c++) {
            cin >> map[r][c];
            
            if(map[r][c] == 1) totCount++;
        }
    }
    // 입력 완료.
    while(totCount > 0) {
        // 외부 영역 체크

        for(int r = 0; r < R+2; r++) {
            for(int c = 0; c < C+2; c++) {
                
                queue<pair<int, int>> que;
                que.push(make_pair(r, c));
                if(map[r][c] != -1) continue;

                while(!que.empty()) {
                    pair<int, int> now = que.front();
                    que.pop();

                    map[now.first][now.second] = -2; 

                    for(int d = 0; d < 4; d++) {
                        int nr = now.first + dr[d];
                        int nc = now.second + dc[d];

                        if(nr < 0 || nr >= R+2 || nc < 0 || nc >= C+2) continue;
                        
                        if(map[nr][nc] == 0) {
                            map[nr][nc] = -1;
                            que.push(make_pair(nr, nc));
                        }
                        if(map[nr][nc] > 0) map[nr][nc]++;
                    }
                }
            }
        }
        // 외부 고려 완료.
        // cout << "outside check ========================\n";
        // for(int r = 1; r <= R; r++) {
        //     for(int c = 1; c <= C; c++) {
        //         printf("%4d", map[r][c]);
        //     }
        //     cout << "\n";
        // }
        // cout << "========================\n";
        
        for(int r = 1; r <= R; r++) {
            for(int c = 1; c <= C; c++) {
                if(map[r][c] >= 3) {
                    map[r][c] = -1;
                    totCount--;
                }
            }
        }
        // 지우기 완료.
        totTime++;


        // cout << "complete erase ========================\n";
        // for(int r = 1; r <= R; r++) {
        //     for(int c = 1; c <= C; c++) {
        //         printf("%4d", map[r][c]);
        //     }
        //     cout << "\n";
        // }
        // cout << "========================\n";
    }

    // 정답 출력.
    cout << totTime;
}
/*

6 6
1 1 1 1 1 1
1 0 0 0 0 1
1 0 1 1 0 1
1 0 1 0 0 1
1 0 0 0 0 1
1 1 1 1 1 1


*/