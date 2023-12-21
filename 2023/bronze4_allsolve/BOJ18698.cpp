#include <iostream>
using namespace std;
int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        string inp; cin >> inp;
        int fall = 0;
        for(char c : inp) {
            if(c == 'U') ++fall;
            else break;
        }
        cout << fall << "\n";
    }
}