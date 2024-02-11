#include <iostream>

using namespace std;

int main() {
    int w, l, h; cin >> w >> l >> h;
    if(w < l) {
        int tmp = w;
        w = l;
        l = tmp;
    }

    if(l/h >= 2 && w <= l*2) cout << "good";
    else cout << "bad";
}