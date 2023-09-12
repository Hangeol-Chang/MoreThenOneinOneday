#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> drdc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

int main() {
    int R, C, K;
    cin >> R >> C >> K;
    
    vector<vector<int>> map(R + 2, vector<int>(C + 2, 0));
    vector<pair<int, int>> mine; 
    for(int i = 0; i < K; i++) {
        int r, c;
        cin >> r >> c;
        mine.push_back(pair<int, int>(r, c));
        
        map[r][c] = 1;
    }

    int ans = 0;
    for(vector<pair<int, int>>::iterator it = mine.begin(); it != mine.end(); it++) {
        int r = it->first;
        int c = it->second;
        
        if(map[r][c] == 0) continue;
        map[r][c] = 0;

        queue<pair<int, int>> que;
        que.push(pair<int, int>(r, c));
        
        int size = 0;
        while(!que.empty()) {
            pair<int, int> now = que.front();
            que.pop();
            size++;

            for(vector<vector<int>>::iterator dd = drdc.begin(); dd != drdc.end(); dd++) {
                int nr = now.first + (*dd)[0];
                int nc = now.second + (*dd)[1];

                if(map[nr][nc] == 1) {
                    map[nr][nc] = 0;
                    que.push(pair<int, int>(nr, nc));
                }
            }
        }

        ans = ans < size ? size : ans;
    }
    cout << ans;
}