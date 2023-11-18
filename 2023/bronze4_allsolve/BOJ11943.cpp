#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int a, b, c, d; cin >> a >> b >> c >> d;
    int ad = a + d;
    int bc = b + c;

    cout << min(ad, bc);
}