#include <iostream>

using namespace std;

int main() {
    int m, M; cin >> m >> M;
    int K, X; cin >> K >> X;

    int lower = K - X > 0 ? K - X : 0;
    int minV = m < lower ? lower : m;
    int maxV = M < K + X ? M : K + X;

    int ans = maxV - minV + 1;
    if(ans > 0) cout << ans;
    else cout << "IMPOSSIBLE";
}