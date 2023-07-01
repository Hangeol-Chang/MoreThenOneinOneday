#include <iostream>
#include <vector>
#include <string>

using namespace std;
#define BOARD vector<vector<int>>

// 10칸의 보드
vector<BOARD> map(10, BOARD( 5, vector<int>(3, 0) ));

long long pow(int alx, int wltn) {
    long long ret = 1;
    while(wltn-- > 0) ret *= alx;
    return ret;
}

void initMap() {
    map[0][0] = {1, 1, 1};
    map[0][1] = {1, 0, 1};
    map[0][2] = {1, 0, 1};
    map[0][3] = {1, 0, 1};
    map[0][4] = {1, 1, 1};

    map[1][0] = {0, 0, 1};
    map[1][1] = {0, 0, 1};
    map[1][2] = {0, 0, 1};
    map[1][3] = {0, 0, 1};
    map[1][4] = {0, 0, 1};
    
    map[2][0] = {1, 1, 1};
    map[2][1] = {0, 0, 1};
    map[2][2] = {1, 1, 1};
    map[2][3] = {1, 0, 0};
    map[2][4] = {1, 1, 1};

    map[3][0] = {1, 1, 1};
    map[3][1] = {0, 0, 1};
    map[3][2] = {1, 1, 1};
    map[3][3] = {0, 0, 1};
    map[3][4] = {1, 1, 1};

    map[4][0] = {1, 0, 1};
    map[4][1] = {1, 0, 1};
    map[4][2] = {1, 1, 1};
    map[4][3] = {0, 0, 1};
    map[4][4] = {0, 0, 1};

    map[5][0] = {1, 1, 1};
    map[5][1] = {1, 0, 0};
    map[5][2] = {1, 1, 1};
    map[5][3] = {0, 0, 1};
    map[5][4] = {1, 1, 1};

    map[6][0] = {1, 1, 1};
    map[6][1] = {1, 0, 0};
    map[6][2] = {1, 1, 1};
    map[6][3] = {1, 0, 1};
    map[6][4] = {1, 1, 1};

    map[7][0] = {1, 1, 1};
    map[7][1] = {0, 0, 1};
    map[7][2] = {0, 0, 1};
    map[7][3] = {0, 0, 1};
    map[7][4] = {0, 0, 1};

    map[8][0] = {1, 1, 1};
    map[8][1] = {1, 0, 1};
    map[8][2] = {1, 1, 1};
    map[8][3] = {1, 0, 1};
    map[8][4] = {1, 1, 1};

    map[9][0] = {1, 1, 1};
    map[9][1] = {1, 0, 1};
    map[9][2] = {1, 1, 1};
    map[9][3] = {0, 0, 1};
    map[9][4] = {1, 1, 1};
}

int main() {
    initMap();
    
    int totZari;
    cin >> totZari;
    vector<BOARD> onBoard(totZari, BOARD(5, vector<int>(3, 0)));
    // #은 1로 / .은 0으로 저장

    for(int r = 0; r < 5; r++) {
        string inp;
        cin >> inp;

        // 012 456 890
        for(int t = 0; t < totZari; t++) {
            for(int c = 0; c < 3; c++) {
                char idf = inp[t*4 + c];
                onBoard[t][r][c] = (idf == '#') ? 1 : 0;
            }
        }
    }
    // 입력 받기 끝;
    
    // 입력 디버깅
    // for(vector<BOARD>::iterator it1 = onBoard.begin(); it1 != onBoard.end(); it1++) {
    //     for(BOARD::iterator it2 = it1->begin(); it2 != it1->end(); it2++) {
    //         for(vector<int>::iterator it3 = it2->begin(); it3 != it2->end(); it3++) {
    //             cout << *it3 << " ";
    //         }
    //         cout << endl;
    //     }
    //     cout << endl;
    // }

    // 가능한 숫자 정리.
    vector<int> possibleNumsSum(totZari, 0);
    vector<int> possibleNumsCount(totZari, 0);
    for(int t = 0; t < totZari; t++) {
        BOARD nowBoard = onBoard[t];
        // 각 숫자를 넣을 수 있는지 확인.
        for(int n = 0; n < 10; n++) {
            BOARD cmp = map[n];

            // 켜져있으면 안되는 것이 켜져있으면 짤.
            for(int r = 0; r < 5; r++)
                for(int c = 0; c < 3; c++)
                    if(nowBoard[r][c] > cmp[r][c])
                        goto nextNum;
            
            possibleNumsSum[t] += n;
            possibleNumsCount[t] += 1;

            nextNum:;
        }
    }

    // 하나라도 불가능하면 끝.
    for(vector<int>::iterator it = possibleNumsCount.begin(); it != possibleNumsCount.end(); it++) {
        if(*it == 0) {
            cout << -1;
            return 0;
        }
    }

    long long sum = 0;

    for(int t = 0; t < totZari; t++) {
        int multiplier = 1;
        int pownum = (totZari - 1) - t;

        for(int t2 = 0; t2 < totZari; t2++) {
            if(t == t2) continue;
            multiplier *= possibleNumsCount[t2];
        }
        sum += pow(10, pownum) * multiplier * possibleNumsSum[t];
    }

    long long totNumCount = 1;
    for(vector<int>::iterator it = possibleNumsCount.begin(); it != possibleNumsCount.end(); it++) totNumCount *= *it;
    double ans = sum * 1.0 / totNumCount;

    printf("%.7f", ans);
}

/*

9
...................................
...................................
...................................
...................................
...................................

*/