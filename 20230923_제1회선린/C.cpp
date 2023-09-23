#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;
    int x, y, r; 
    cin >> x >> y >> r;

    int minR = x - r;
    int maxR = x + r;

    int a1 = 0, a2 = 0;
    for(int i = 1; i <= N; i++) {
        int lx; cin >> lx;
        
        if(lx == minR || lx == maxR) ++a2;
        if(lx > minR && lx < maxR) ++a1;
    } 
    
    cout << a1 << " " << a2;
}