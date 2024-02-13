#include <iostream>
#include <cstring>

using namespace std;

int main() {
    // es = 20
    // st = 17
    int ans = 0;
    for(int i = 0; i < 4; i++) {
        string a;
        int b;
        cin >> a >> b;
        
        if(strcmp(a.c_str(), "Es") == 0) {
            ans += b * 21;
        }
        else ans += b * 17;
    }
    cout << ans;
}