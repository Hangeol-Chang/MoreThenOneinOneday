#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main() {
    string inp; cin >> inp;
    
    int ans = 0;
    for(int i = 0; i < inp.length() - 3; i++) {
        if(inp[i] == 'D') {
            string part = inp.substr(i, 4);
            if(strcmp(part.c_str(), "DKSH") == 0) {
                ans++;
                i += 3;
            }
        }
    }
    cout << ans;
}