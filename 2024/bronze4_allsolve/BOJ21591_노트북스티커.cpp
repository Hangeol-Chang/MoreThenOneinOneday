#include <iostream>

using namespace std;

int main() {
    int W, H, w, h;
    cin >> W >> H >> w >> h;

    if(W >= w + 2 && H >= h + 2) cout << 1;
    else cout << 0;
}