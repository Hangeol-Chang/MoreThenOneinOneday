#include <iostream>

using namespace std;

int R, C, limit;
int **map;
int **ansMap;

int run(int start, int limit, int count) {
    // 바뀔 수 없는 부분이 같은가.
    int rs = start/(C-2);
    int cs = start%(C-2);

    for(int r = 0; r < rs; r++)
        for(int c = 0; c < C; c++)
            if(map[r][c] != ansMap[r][c]) return -1;    
    for(int c = 0; c < cs; c++)
        if(map[rs][c] != ansMap[rs][c]) return -1; 

    // 맞는지 판단
    for(int i = rs; i < R; i++)
        for(int j = 0; j < C; j++)
            if(map[i][j] != ansMap[i][j]) goto outer;
    return count;
    outer:;

    for(int idx = start; idx < limit; idx++) {
        int r = idx/(C-2);
        int c = idx%(C-2);

        // cout << idx << " " <<  r << " " << c << "\n";

        // 바꾸고
        for(int i = r; i <= r+2; i++)
            for(int j = c; j <= c+2; j++)
                map[i][j] = 1 - map[i][j];
        
        int tmpans = run(idx + 1, limit, count + 1);
        if(tmpans != -1) return tmpans;

        // 안되면 돌려놓기
        for(int i = r; i <= r+2; i++)
            for(int j = c; j <= c+2; j++)
                map[i][j] = 1 - map[i][j];
    }
    return -1;
}

void mapInput(int **mapAddr) {
    for(int r = 0; r < R; r++) {
        mapAddr[r] = new int[C];
        string tmp; cin >> tmp;
        for(int c = 0; c < C; c++) mapAddr[r][c] = tmp[c] - '0';
    }
}

int main() {
    cin >> R >> C;
    map    = new int *[R];
    ansMap = new int *[R];
    // 초기 배열 입력받기
    mapInput(map);
    mapInput(ansMap);

    if(R-2 <= 0 || C-2 <= 0) {
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++)
                if(map[i][j] != ansMap[i][j]) {
                    cout << -1;
                    return 0;
                }
        cout << 0; 
        return 0;
    }

    limit = (R - 2) * (C - 2);
    cout << run(0, limit, 0);
    return 0;
}

/*

5 6
000000
000000
000000
000000
000000
000000
000000
000000
000000
000000

*/