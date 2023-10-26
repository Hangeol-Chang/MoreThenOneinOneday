#include <iostream>

using namespace std;

int main() {
    int a, b; cin >> a >> b;

    if(!(a >= 12 && a <= 16) || b == 1) cout << 280;
    else cout << 320;
}