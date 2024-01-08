#include <iostream>
using namespace std;

int main() {
    int T; cin >> T;
    
    for(int t = 1; t <= T; t++) {
        int a, b;
        cin >> a >> b;
        
        if(a < 3 && b < 3 && a + b <= 3) cout << "Yes\n";
        else cout << "No\n";
    }
}
