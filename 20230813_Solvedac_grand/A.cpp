#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    int ans1 = 0;
    for(int i = 1; i <= n; i++) ans1 += i;

    int ans2 = ans1 * ans1;
    cout << ans1 << "\n" << ans2 << "\n" << ans2;
}