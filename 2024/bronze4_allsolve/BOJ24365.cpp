#include <iostream>

using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    int avg = (a + b + c)/3;

    int ans = 0;
    while(c > avg) {
        ++b;
        --c;
        ++ans;
    }

    while(b > avg) {
        ++a;
        --b;
        ++ans;
    }
    cout << ans;
}