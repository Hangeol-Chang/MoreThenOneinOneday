#include <iostream>

using namespace std;

int main() {
    int T;
    cin >> T;
    // 11 8 12
    
    for(int t = 0; t < T; t++) {
        int id, a, b, c; 
        cin >> id >> a >> b >> c;
        int ans = a + b + c;

        string res = "PASS";
        if(ans < 55) res = "FAIL";
        if(a < 11) res = "FAIL";
        if(b < 8) res = "FAIL";
        if(c < 12) res = "FAIL";

        cout << id << " " << ans << " " << res << "\n";
        
    }
}