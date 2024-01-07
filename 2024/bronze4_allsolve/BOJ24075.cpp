#include <iostream>

using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    
    int c = a + b;
    int d = a - b;
    if(d > c) cout << d << "\n" << c;
    else cout << c << "\n" << d;
}
