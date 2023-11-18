#include <iostream>

using namespace std;

int main() {
    int n; cin >> n;
    
    int ans = 0;
    for(int i = 0; i < 5; i++) {
        int tmp; cin >> tmp;
        if(tmp == n) ++ans;
    }
    cout << ans;
}