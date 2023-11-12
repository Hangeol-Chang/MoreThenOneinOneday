#include <iostream>

using namespace std;

int main() {
    long long a, b;
    cin >> a >> b;
    
    if(a % 2 == 0 || b % 2 == 0) cout << 0;
    else {
        if( a <= b) cout << a;
        else cout << b;
    }
}