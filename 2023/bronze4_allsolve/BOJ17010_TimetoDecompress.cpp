#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    
    for(int t = 1; t <= T; t++) {
        int n;
        string s;
        cin >> n >> s;
        
        
       for(int i = 0; i < n; i++) {
           cout << s;
       }
       cout << "\n";
    }
}
