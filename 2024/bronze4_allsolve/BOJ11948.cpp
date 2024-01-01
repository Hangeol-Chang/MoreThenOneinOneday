#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int a, b, c, d, e, f;
    cin >> a >> b >> c >> d >> e >> f;
    int ans;
    ans += a + b + c + d + e + f;

    ans -= min(a, min(b, min(c, d)));
    ans -= min(e, f);
    cout << ans;
}