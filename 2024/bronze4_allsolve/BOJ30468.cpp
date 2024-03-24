#include <iostream>

using namespace std;

int main() {
    int a, b, c, d, N;
    cin >> a >> b >> c >> d >> N;
    int now = a + b + c + d;
    N *= 4;

    int ans = N - now < 0 ? 0 : N - now;
    cout << ans;
}