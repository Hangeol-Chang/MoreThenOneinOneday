#include<iostream>

using namespace std;

int main() {
    int T;
    cin >> T;
    for(int t = 1; t <= T; t++) {
        string a;
        cin >> a;
        if(a.length() >= 6 && a.length() <= 9) cout << "yes\n";
        else cout << "no\n";
    }
}