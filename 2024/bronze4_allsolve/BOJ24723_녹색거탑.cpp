#include <iostream>

using namespace std;

int main() {
    int n; cin >> n;
    
    int ans = 2;
    while(--n > 0) ans *= 2;
    cout << ans;
}