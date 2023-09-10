#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        int rank; cin >> rank;

        int round = 0;
        if(rank > 4500)         round = 1;
        else if(rank > 1000)    round = 2;
        else if(rank > 25)      round = 3;

        cout << "Case #" << t << ": ";
        if(round == 0) cout << "World Finals\n";
        else cout << "Round " << round << "\n";
    }
}