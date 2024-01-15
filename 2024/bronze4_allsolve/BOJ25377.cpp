#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;
    int ans = -1;
    for(int n = 1; n <= N; n++) {
        int a, b; cin >> a >> b;
        if(a > b) continue;
        else {
            if(ans == -1)   ans = b;
            else            ans = min(ans, b);
        }
    }
    cout << ans;
}