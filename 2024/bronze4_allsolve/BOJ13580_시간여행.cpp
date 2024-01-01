#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> a(3, 0);
    for(int i = 0; i < 3; i++) cin >> a[i];

    sort(a.begin(), a.end());

    if( a[0] == a[1] ||
        a[1] == a[2] ||
        a[0] + a[1] == a[2]    
    ) cout << "S";
    else cout << "N";
}