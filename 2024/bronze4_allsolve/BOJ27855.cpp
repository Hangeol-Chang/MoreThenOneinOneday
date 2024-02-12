#include <iostream>

using namespace std;

int main() {
    int a1, b1, a2, b2; cin >> a1 >> b1 >> a2 >> b2;
    
    int s1 = a1*3 + b1;
    int s2 = a2*3 + b2;

    if(s1 == s2) {
        cout << "NO SCORE";
        return 0;
    }

    if(s1 > s2) cout << 1;
    else if(s1 < s2) cout << 2;
    cout << " " << abs(s1 - s2);
}