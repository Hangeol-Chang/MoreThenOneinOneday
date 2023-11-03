#include <iostream>

using namespace std;

int main() {
    int d, h, m;
    cin >> d >> h >> m;
    int tot = (d * 24 * 60 + h * 60 + m) - ( 11 * 24 * 60 + 11 * 60 + 11);
    // cout << tot << "\n";
    if(tot < 0) cout << -1;
    else cout << tot;
}