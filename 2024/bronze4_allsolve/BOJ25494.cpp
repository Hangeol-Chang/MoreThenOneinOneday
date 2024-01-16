#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        int a, b, c; cin >> a >> b >> c;
        cout << min(a, min(b, c)) << "\n";
    }
}