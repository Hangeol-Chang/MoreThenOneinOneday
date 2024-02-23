#include <iostream>

using namespace std;

int main() {
    int a, b; cin >> a >> b;
    bool ans = a + b*7 <= 30;
    cout << ans;
}