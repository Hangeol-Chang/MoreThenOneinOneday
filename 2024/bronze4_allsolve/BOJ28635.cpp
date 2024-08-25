#include <iostream>

using namespace std;

int main() {
    int m, a, b;
    
    cin >> m >> a >> b;
    int ans = 0;
    while(a != b) {
        ans++;
        a++;
        if(a > m) a = 1;
    }
    cout << ans;
}