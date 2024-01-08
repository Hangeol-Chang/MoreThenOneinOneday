#include <iostream>

using namespace std;

int main() {
    int x, y, z; cin >> x >> y >> z;
    if( x*1.0 + y > z*1.0 + 0.5 ) cout << 0;
    else cout << 1;
}