#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    int ans = 10000;

    for(int t = 1; t <= T; t++) {
        int a, b; cin >> a >> b;
        ans = min(a+b, ans);
    }
    cout << ans;
}