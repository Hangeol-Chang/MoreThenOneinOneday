#include <iostream>
#include <vector>

using namespace std;

vector<int> ans(2, 0);  // 0 : white, 1 : blue
vector<vector<int>> board;

void run(int rs, int cs, int size) {
    int mainC = board[rs][cs];    // 이번 판의 색
    
    if(size == 1) {
        ans[mainC] += 1;
        return;
    }

    for(int r = rs; r < rs + size; r++) {
        for(int c = cs; c < cs + size; c++) {
            if(board[r][c] != mainC) {
                // 2 * 2로 나눠서 네군데
                int s2 = size / 2;
                run(rs, cs, s2);
                run(rs + s2, cs, s2);
                run(rs, cs + s2, s2);
                run(rs + s2, cs + s2, s2);

                return;
            }      
        }
    }
    ans[mainC] += 1;
    return;
}

int main() {
    int N; cin >> N;
    board = vector<vector<int>>(N, vector<int>(N, 0));

    for(int r = 0; r < N; r++)
        for(int c = 0; c < N; c++)
            cin >> board[r][c];

    run(0, 0, N);

    cout << ans[0] << "\n" << ans[1];
}