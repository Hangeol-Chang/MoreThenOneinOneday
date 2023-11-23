#include <iostream>

using namespace std;

int main() {
    int a, b, c; cin >> a >> b >> c;

    if(a == b && b == c) cout << "*";
    else {
        if(a == b) cout << "C";
        else if(b == c) cout << "A";
        else cout << "B";
    }
}