#include <iostream>

using namespace std;

int main() {
    int a, b, c; cin >> a >> b >> c;
    int d = b/2 + c;
    cout << min(a, d);
}