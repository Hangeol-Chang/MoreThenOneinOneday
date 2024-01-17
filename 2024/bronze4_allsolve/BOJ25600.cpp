#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;
    int ans = 0;
    for(int n = 0; n < N; n++) {
        int a, d, g; cin >> a >> d >> g;
        int sc = a * (d + g);
        if (a == d + g) sc *= 2;
        ans = max(ans, sc);
    }
    cout << ans;
}