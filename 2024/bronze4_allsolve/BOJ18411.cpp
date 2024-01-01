#include <iostream>

using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    int mv = min(a, min(b, c));

    cout << a + b + c - mv;
}