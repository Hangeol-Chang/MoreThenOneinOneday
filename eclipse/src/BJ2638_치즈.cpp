#include <iostream>

using namespace std;

int dr = {-1, 1, 0, 0};
int dc = {0, 0, -1, 1};

int main() {
    // 치즈의 주변 노출 숫자를 저장.
    int R, C;
    cin >> R >> C;
    
    int **map;
    map = new int *[R+2];
    for(int r = 1; r <= R; r++) {
        map[r] = new int[C+2];
        for(int c = 1; c <= C; c++) {
            int tmp;
            cin >> tmp;
            if(tmp == 1) {
                map[r][c] += 4;
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    map[nr][nc]--;
                }
            }
        }
    }
}