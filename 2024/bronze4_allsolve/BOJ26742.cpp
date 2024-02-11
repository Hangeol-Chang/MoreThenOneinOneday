#include <iostream>

using namespace std;

int main() {
    int cc = 0;
    int bc = 0;

    string inp; cin >> inp;
    for(char c : inp) {
        if(c == 'B') ++bc;
        else ++cc;
    }

    cout << bc/2 + cc/2;
}