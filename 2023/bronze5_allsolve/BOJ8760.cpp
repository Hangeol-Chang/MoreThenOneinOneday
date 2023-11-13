#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 0; t < T; t++) {
        int a, b; cin >> a >> b;
        cout << (a * b) / 2 << "\n";
    }
}