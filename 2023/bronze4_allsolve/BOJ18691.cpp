#include <iostream>

using namespace std;

int main() {
    int T;
    cin >> T;

    for(int t = 1; t <= T; t++) {
        int G, C, E;
        cin >> G >> C >> E;
        int walk = G * 2  - 1;
        int need = E - C;

        if(need < 0) need = 0;
        int needWalk = need * walk;
        cout << needWalk << "\n";
    }
}