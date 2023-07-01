#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};
int **map;
int R, C;

class loc {
    public : 
        int r, c;
        loc(int rin, int cin) {
            r = rin;
            c = cin;
        }
};

void bfs(int r, int c) {
    queue<loc> que;
    que.push(loc(r, c));

    while(!que.empty()) {
        loc now = que.front();
        que.pop();

        for(int d = 0; d < 4; d++) {
            int nr = now.r + dr[d];
            int nc = now.c + dc[d];

            if(nr < 0 || nr >= R+1 || nc < 0 || nc >= C+1 || map[nr][nc] == 4) continue;
            
            map[nr][nc]--;
            que.push(loc(nr, nc));
        }
    }
}

int main() {
    // 치즈의 주변 노출 숫자를 저장.
    cin >> R >> C;
    
    vector<loc> cheeseloc;
    int cheesecount = 0;
    map = new int *[R+2];
    for(int r = 0; r <= R+1; r++) {
        map[r] = new int[C+2];
        fill_n(map[r], sizeof(map[r]), -1);
    }

    for(int r = 1; r <= R; r++)
        for(int c = 1; c <= C; c++) {
            int tmp;
            cin >> tmp;
            // 치즈가 있으면
            if(tmp == 1) {
                map[r][c] = 4;
                cheeseloc.push_back(loc(r, c));
            }
            else map[r][c] = -1;
        }
    // 입력 완료.
    
    // 데이터 정제
    vector<loc>::iterator iter;
    for(iter = cheeseloc.begin(); iter != cheeseloc.end(); ++iter) {
        loc now = *iter;

        for(int d = 0; d < 4; d++) {
            int nr = now.r + dr[d];
            int nc = now.c + dc[d];

            if(map[nr][nc] == -1) continue;
            map[nr][nc]--;
        }
    }
    // 외부와 차단된 곳이 있는지 확인.

    // r = 0 R+1, c = 0 C+1 일 때 순회하면서 외부와 접촉된 곳 깍기.
    for(int r = 1; r <= R; r++)
        for(int c = 1; c <= C; c++)
            if(map[r][c] == -1) 
                bfs(r, c);

    cout << endl;
    for(int r = 1; r <= R; r++) {
        for(int c = 1; c <= C; c++) printf("%2d ", map[r][c]);
        cout << endl;
    }
    

    // 빌때까지 계속
    int time = 0;
    while(!cheeseloc.empty()) {
        
        cout << cheeseloc.size() << endl;
        for(int r = 1; r <= R; r++) {
            for(int c = 1; c <= C; c++) printf("%2d ", map[r][c]);
            cout << endl;
        }

        vector<loc> er;

        // 사라지는 치즈 찾기.
        for(iter = cheeseloc.begin(); iter != cheeseloc.end(); ++iter) {            
            loc now = *iter;

            // 이번에 지워질 수 있으면,
            if(map[now.r][now.c] >= 2) {
                er.push_back(*iter);
                cheeseloc.erase(iter);
                // cout << now.r << " " << now.c << endl;
                map[now.r][now.c] = -1;
                iter--;
            }
        }

        // 치즈 지우기.
        for(iter = er.begin(); iter != er.end(); ++iter) {
            loc now = *iter;

            for(int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                
                // 치즈가 없으면 지나가기.
                if(map[nr][nc] == -1) continue;
                // 치즈가 있으면 접촉면 늘리기.
                map[nr][nc]++;
            }
        }
        time++;
    }
    cout << time;
}

/*

8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0



*/