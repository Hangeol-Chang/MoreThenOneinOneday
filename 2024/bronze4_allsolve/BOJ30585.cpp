#include <iostream>

using namespace std;

int main() {
    int H, W; cin >> H >> W;

    int c0 = 0, c1 = 0;
    for(int h = 0; h < H; h++) {
        string inp;
        cin >> inp;
        for(char c : inp) {
            if(c == '0')    ++c0;
            else            ++c1;
        }
    }
    int ans = c0 < c1 ? c0 : c1;
    cout << ans;
}