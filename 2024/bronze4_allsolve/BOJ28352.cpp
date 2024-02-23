#include <iostream>

using namespace std;

int main() {
    int n; cin >> n;

    long long ans = 1;
    while(n > 10) {
        ans *= n;
        n--;
    }
    cout << ans * 6;
}