#include <iostream>

using namespace std;

int main() {
    int t1, m1, t2, m2;
    cin >> t1 >> m1 >> t2 >> m2;
    
    int p1 = t1 * 60 + m1;
    int p2 = t2 * 60 + m2;

    if(p2 < p1) p2 += 1440;
    int ans = p2 - p1;
    cout << ans << " " << ans/30;
}