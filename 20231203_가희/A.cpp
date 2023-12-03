#include <iostream>
#include <vector>

using namespace std;

int main() {
    int a; cin >> a;
    
    vector<int> candis;
    for(int i = 0; i < 4; i++) {int tmp; cin >> tmp; candis.push_back(tmp);}

    int ans = 0;
    for(auto it = candis.begin(); it != candis.end(); it++) {
        if (a - *it <= 1000) ans++;
    }
    cout << ans;
}