#include <iostream>

using namespace std;

int main() {
    int ans = 0;
    int n; cin >> n;

    for(int i = 0; i < 5; i++) {
        int num; cin >> num;
        if(num == n) ++ans;
    }
    cout << ans;
}