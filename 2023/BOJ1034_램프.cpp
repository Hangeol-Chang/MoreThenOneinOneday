#include <iostream>
#include <vector>

using namespace std;

int ans = 0;
int R, C;

void getAns(vector<vector<bool>> map) {
    int newans = 0;

    for(vector<vector<bool>>::iterator it = map.begin(); it != map.end(); it++) {
        
    }
}


void run(int left, int64_t bit, vector<vector<bool>> map) {
    // 맵의 모든 부분을 눌러보기.
    // 
    if(left % 2 == 0) {
        getAns(map);    
    }
}

int main() {
    cin >> R >> C;

    vector<vector<bool>> map(R, vector<bool>(C, 0));

    for(int r = 0; r < R; r++) {
        string line;
        cin >> line;
        for(int c = 0; c < C; c++) {
            int now = int(line.at(c));
            if(now == 1) map[r][c] = 1;
        }
    }
    int K; cin >> K;
    // 입력 완료.
    
    run(K, 0, map);
}