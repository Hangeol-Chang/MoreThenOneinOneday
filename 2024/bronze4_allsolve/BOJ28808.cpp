#include <iostream>

using namespace std;

int main() {
    int n, m; cin >> n >> m;
    int ans = 0;
    for(int i = 0; i < n; i++) {
        string line;
        cin >> line;
        
        for(char c : line) {
            if(c == '+') {
                ans++;
                break;
            }
        }
    }
    cout << ans;
}