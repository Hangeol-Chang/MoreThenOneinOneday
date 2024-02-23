#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    int ans = 0;
    for(int t = 1; t <= T; t++) {
        int w, h; cin >> w >> h;
        ans = max(w*h, ans);
    }
    cout << ans;
}