#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    int R, C; cin >> R >> C;
    
    vector<string> map1(R, "");
    for(int r = 0; r < R; r++) cin >> map1[r];

    vector<string> map2(R, "");
    for(int r = 0; r < R; r++) cin >> map2[r];

    int ans = 0;
    for(int r = 0; r < R; r++) {
        for(int c = 0; c < C; c++) {
            if(map1[r][c] == map2[r][c]) ++ans;
        }
    }
    cout << ans;
}