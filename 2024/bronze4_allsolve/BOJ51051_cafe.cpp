#include <iostream>

using namespace std;

int main() {
    int p1, p2, p3; cin >> p1 >> p2 >> p3;
    
    int m1 = p2 * 2 + p3 * 4;
    int m2 = p1 * 2 + p3 * 2;
    int m3 = p1 * 4 + p2 * 2;
    
    cout << min(m1, min(m2, m3));
}