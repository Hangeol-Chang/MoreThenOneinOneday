
#include <iostream>

using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    
    int ans = 0;
    while(a >= 2 && b >= 2) {
        a -= 2;
        b -= 2;
        ans ++;
    }
    cout << ans;
}
