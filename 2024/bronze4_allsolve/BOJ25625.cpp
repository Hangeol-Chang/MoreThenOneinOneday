#include <iostream>

using namespace std;

int main() {
    int x, y; cin >> x >> y;
    
    if(y >= x) cout << y - x;
    else cout << x + y;
}
