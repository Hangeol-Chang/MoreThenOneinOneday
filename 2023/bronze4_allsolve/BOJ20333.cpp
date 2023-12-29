#include <iostream>

using namespace std;

int main() {
    int a, x, b, y, T;
    cin >> a >> x >> b >> y >> T;

    int v1 = T - 30;
    if(v1 < 0) v1 = 0;

    int v2 = T - 45;
    if(v2 < 0) v2 = 0;

    cout << a + v1 * x * 21 << " " << b + v2 * y * 21;
}