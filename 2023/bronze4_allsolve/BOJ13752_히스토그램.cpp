#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;

    for(int t = 1; t <= T; t++) {
        int N;
        cin >> N;
        while(N-- > 0) cout << "=";
        cout << "\n";
    }
}