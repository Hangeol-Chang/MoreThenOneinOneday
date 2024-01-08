#include <iostream>

using namespace std;

int main() {
    int ans = 0;
    while(true) {
        int a;
        cin >> a;
        if(a == -1) break;
        
        ans += a;
    }
    cout << ans;
}
