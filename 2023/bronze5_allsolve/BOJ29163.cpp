#include <iostream>

using namespace std;

int main() {
    int ev = 0;
    int od = 0;
    
    int n; cin >> n;
    for(int i = 0; i < n; i++) {
        int a; cin >> a;
        if(a % 2 == 0) ++ev;
        else ++od;
    }
    
    if(ev > od) cout << "Happy";
    else cout << "Sad";
}