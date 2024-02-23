#include <iostream>

using namespace std;

int main() {
    string a, b;
    cin >> a >> b;
    int len = a.length();
    
    string ans = "";
    for(int i = 0; i < len; i++) {
        char aa = a[i];
        char bb = b[i];
        
        ans += aa > bb ? aa : bb;
    }
    cout << ans;
}