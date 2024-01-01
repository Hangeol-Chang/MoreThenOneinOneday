#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<pair<int, int>> a(3, pair<int, int>(0, 0));
    for(int i = 0; i < 3; i++) cin >> a[i].first;
    for(int i = 0; i < 3; i++) cin >> a[i].second;


    int ans = 0;
    for(auto it = a.begin(); it != a.end(); it++) {
        int p = it->second - it->first;
        if(p > 0) ans += p;
    }
    cout << ans;
}