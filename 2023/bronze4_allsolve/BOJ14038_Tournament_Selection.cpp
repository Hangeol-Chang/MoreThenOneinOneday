#include <iostream>

using namespace std;

int main() {
    char c;
    int win = 0;
    for(int i = 0; i < 6; i++) {
        cin >> c;
        if(c == 'W') ++win;
    }

    if(win >= 5) cout << 1;
    else if(win >= 3) cout << 2;
    else if(win >= 1) cout << 3;
    else cout << -1;
}