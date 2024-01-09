#include <iostream>

using namespace std;

int main() {
    string inp; cin >> inp;
    int loc = 0;

    string ans = "";
    int size = inp.size();
    while( loc < size ) {
        ans += inp[loc];
        loc += inp[loc] - 'A' + 1;
        // cout << ans << "\n";
    }

    cout << ans;
}