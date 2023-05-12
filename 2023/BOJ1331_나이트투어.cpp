#include <iostream>

using namespace std;

int *map[6];

bool canMove(int row1, int row2, int col1, int col2) {
    int tag1 = abs(row2 - row1);
    int tag2 = abs(col2 - col1);


    // 나이트가 움직일 수 없는 범위.
    if( abs(tag1 - tag2) == 1 && tag1 + tag2 == 3 ) {
        return true;
    }
    return false;
}

int main() {
    // map 초기화.   
    for(int i = 0; i < 6; i++) {
        map[i] = new int[6];
        fill_n(map[i], 6, 0);
    }
    
    char input[3];

    int st_row = -1;
    int st_col = -1;

    int prev_row = -1;
    int prev_col = -1;

    bool pass = true;
    for(int i = 0; i < 36; i++) {
        cin >> input;

        int row = input[0] - 'A';
        int col = input[1] - '1';

        // 이미 방문했던곳 처리.
        if(map[row][col] == 1) {
            pass = false; 
            break;
        }
        // 이전꼐 있으면 체크할것들.
        if(prev_col != -1) { 
            pass = canMove(prev_row, row, prev_col, col);
            if(!pass) break;
        }
        else {
            st_row = row;
            st_col = col;
        }

        // 방문처리.
        map[row][col] = 1;

        // 이동위치 넣기.
        prev_row = row;
        prev_col = col;

        // for(int r = 0; r < 6; r++) {
        //     for(int c = 0; c < 6; c++) {
        //         cout << map[r][c] << " ";
        //     }
        //     cout << endl;
        // }
        // cout << endl;
    }
    if(pass) pass = canMove(prev_row, st_row, prev_col, st_col);
    
    if(pass) cout << "Valid";
    else     cout << "Invalid";
}