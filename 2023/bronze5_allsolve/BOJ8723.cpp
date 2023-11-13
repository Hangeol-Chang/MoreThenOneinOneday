#include <iostream>
#include <algorithm>

using namespace std;

// x 0, 직각 1, 정 2
int main() {
    int a, b, c; cin >> a >> b >> c;
    if(a == b && b == c) {
        cout << 2;
        return 0;
    }
    
    int minN = min(a, min(b, c));
    int maxN = max(a, max(b, c));
    int midN = min(max(a, b), max(min(a, b), c));

    if(minN*minN + midN*midN == maxN*maxN) {
        cout << 1;
    }
    else cout << 0;
}