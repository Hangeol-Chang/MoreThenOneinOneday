#include <iostream>
#include <vector>

using namespace std;

int main() {

    vector<int> vv(3, 0);
    for(int i = 0; i < 3; i++) {
        int t; cin >> t;
        vv[t] += 1;
    }

    if(vv[1] > vv[2]) cout << 1;
    else cout << 2;
}