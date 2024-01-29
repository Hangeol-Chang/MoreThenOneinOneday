#include <iostream>

using namespace std;

int main() {
    string a; cin >> a;

    int ans = 0;
    for(auto c : a) {
        if(
            c == 'a' ||
            c == 'e' ||
            c == 'i' ||
            c == 'o' ||
            c == 'u'
        )
            ++ans;
    }
    cout << ans;
}