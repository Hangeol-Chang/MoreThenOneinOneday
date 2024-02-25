#include <iostream>

using namespace std;

int main() {
    int N, A; cin >> N >> A;
    
    int ans = 0;
    for(int n = 1; n <= N; n++) {
        int cost; cin >> cost;
        ans += cost / A;
    }
    cout << ans;
}