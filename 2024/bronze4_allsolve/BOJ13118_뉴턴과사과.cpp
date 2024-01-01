#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    vector<int> plocs(5, 0);
    for(int i = 1; i <= 4; i++) cin >> plocs[i];

    int ax, ay, ar; cin >> ax >> ay >> ar;

    int ans = 0;
    for(int i = 1; i <= 4; i++) {
        if(ax == plocs[i]) {
            ans = i;
            break;
        }
    }
    cout << ans;
}