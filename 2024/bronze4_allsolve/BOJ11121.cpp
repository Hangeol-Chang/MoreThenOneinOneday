#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 0; t < T; t++) {
        string a, b;
        cin >> a >> b;
        int len = a.size();
        int lenb= b.size();
        
        if(len != lenb) {
            cout << "ERROR\n";
            goto outer;
        }

        for(int i = 0; i < len; i++) {
            if(a[i] != b[i]) {
                cout << "ERROR\n";
                goto outer;
            }
        }

        cout << "OK\n";
        outer:;
    }
}