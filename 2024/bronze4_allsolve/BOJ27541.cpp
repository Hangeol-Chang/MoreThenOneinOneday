#include <iostream>

using namespace std;

int main() {
    int l;
    string inp;
    cin >> l >> inp;

    string ans = "";
    if(inp[l - 1] == 'G') ans = inp.substr(0, l-1); 
    else ans = inp + 'G';
    cout << ans;
}