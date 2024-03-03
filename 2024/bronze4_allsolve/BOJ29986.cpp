#include <iostream>

using namespace std;

int main() {
    int N, height; cin >> N >> height;

    int ans = 0;
    for(int n = 1; n <= N; ++n) {
        int k; cin >> k;
        if(k <= height) ++ans;
    }
    cout << ans;
}