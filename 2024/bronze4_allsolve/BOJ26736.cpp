#include <iostream>

using namespace std;

int main() {
    int ac = 0;
    int bc = 0;

    string inp; cin >> inp;
    for(char c : inp) {
        if(c == 'A') ++ac;
        else if (c == 'B') ++bc;
    }

    cout << ac << " : " << bc;
}