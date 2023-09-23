#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    long long ans = 0;
    int a; cin >> a;
    ans += 180 * (a - 2);

    for(int i = 1; i < N; i++) {
        cin >> a;
        ans += 180 * a;
    }
    cout << ans;
}


