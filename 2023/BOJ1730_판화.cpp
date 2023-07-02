#include <iostream>
#include <vector>
#include <string>

using namespace std;
// 46 124 45 43
// . | - +

int main() {
    int N;          cin >> N;
    string orders;  cin >> orders;

    vector<vector<char>> board(N, vector<char>(N, '.'));
    
    int r = 0, c = 0;

    for(char order : orders) {
        int nr, nc;
        char idf;

        switch(order) {
            // 이동 위치 잡기.
            case 'D' :  nr = r + 1; nc = c; idf = '|'; break;
            case 'U' :  nr = r - 1; nc = c; idf = '|'; break;
            case 'L' :  nr = r; nc = c - 1; idf = '-'; break;
            case 'R' :  nr = r; nc = c + 1; idf = '-'; break;
        }
        // 유효성 검사.
        if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
        // cout << nr << " " << nc << " " << idf << " " << board[r][c] << "\n";

        if(board[r][c] == '+') {} 
        else if (board[r][c] == '-') {
            if(idf == '|') 
                board[r][c] = '+';
        }
        else if (board[r][c] == '|') {
            if(idf == '-') 
                board[r][c] = '+';
        }
        else {
            board[r][c] = idf;
        }

        if(board[nr][nc] == '+') {}
        else if (board[nr][nc] == '-') {
            if(idf == '|') board[nr][nc] = '+';
        }
        else if (board[nr][nc] == '|') {
            if(idf == '-') board[nr][nc] = '+';
        }
        else board[nr][nc] = idf;
        
        r = nr; c = nc;
    }

    for(vector<vector<char>>::iterator it = board.begin(); it != board.end(); it++) {
        for(vector<char>::iterator it2 = it->begin(); it2 != it->end(); it2++) {
            printf("%c", *it2);
        }
        printf("\n");
    }
}