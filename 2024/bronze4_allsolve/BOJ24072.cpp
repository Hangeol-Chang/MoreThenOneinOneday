#include <iostream>

using namespace std;

int main() {
    int a, b, c; cin >> a >> b >> c;
    
    if(c >= a && c < b) cout << 1;
    else cout << 0;
}
