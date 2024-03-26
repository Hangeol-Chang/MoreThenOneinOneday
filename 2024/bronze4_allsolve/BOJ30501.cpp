#include <iostream>

using namespace std;

int main() {
    int n; cin >> n;
    for(int i = 1; i <= n; i++) {
        string inp;
        cin >> inp;
        
        for(char c : inp) {
            if(c == 'S') {
                cout << inp;
                return 0;
            }
        }
    }
}