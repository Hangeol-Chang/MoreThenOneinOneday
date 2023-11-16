#include <iostream>

using namespace std;

int main() {
    int m, d; cin >> m >> d;

    if(m == 2) {
        if(d == 18) cout << "Special";
        else if (d < 18) cout << "Before";
        else cout << "After";
    }
    else {
        if(m == 1) cout << "Before";
        else cout << "After";
    }
}