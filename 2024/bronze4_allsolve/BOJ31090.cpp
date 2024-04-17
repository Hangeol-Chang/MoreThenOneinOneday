#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        int y; cin >> y;
        int q = y + 1;
        if(q % (y % 100) == 0) cout << "Good\n";
        else cout << "Bye\n";
    }
}