#include <iostream>

using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    if(a > b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    if(a == b) {
        cout << a + b;
    }
    else {
        cout << 2*a + 1;
    }
}