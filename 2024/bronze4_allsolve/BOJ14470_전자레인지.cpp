#include <iostream>

using namespace std;

int main() {
    int a, b, c, d, e;
    cin >> a >> b >> c >> d >> e;

    int ans = 0;

    if(a <= 0) ans += (-a) * c + d;
    ans += e * (b - max(a, 0));
    cout << ans;
}