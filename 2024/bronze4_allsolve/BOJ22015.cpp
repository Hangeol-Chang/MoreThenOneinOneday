#include <iostream>

using namespace std;

int main() {
    int a, b, c; cin >> a >> b >> c;
    int M = max(a, max(b, c));
    cout << 3*M - (a + b + c);
}
