#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        int n, c; cin >> n >> c;
        cout << n << " " << c << "\n" << n*c - (n-1)*2 << "\n";
    }
}