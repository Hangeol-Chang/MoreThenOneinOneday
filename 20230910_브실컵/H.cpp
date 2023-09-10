#include <iostream>
#include <vector>

using namespace std;

int main() {
    int R, C;
    cin >> R >> C;
    
    vector<int> map(C, 0);

    for(int r = 0; r < R; r++) {
        for(int c = 0; c < C; c++) {
            int num;
            cin >> num;
            map[c] += num;        
        }
    }
    
    int Col; cin >> Col;

    int ans = 0;
    for(int i = 0; i < Col; i++) ans += map[i];

    int cand = ans;
    for(int c = 0; c < C - Col; c++) {
        cand = cand - map[c] + map[c + Col];
        ans = ans < cand ? cand : ans;
    }
    cout << ans;
}