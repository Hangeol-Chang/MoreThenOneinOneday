#include <iostream>

using namespace std;

int main() {
    int a, b; cin >> a >> b;
    int ans = 0;

    b += 60;
    int c = a - b > 0 ? a - b : 0;

    cout << min(a, b) * 1500 + c * 3000;
}