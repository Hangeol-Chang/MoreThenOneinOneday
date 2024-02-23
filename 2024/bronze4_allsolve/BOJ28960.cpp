#include <iostream>

using namespace std;


bool dry(int h, int w, int mh, int mw) {
    if(h >= mh && w >= mw) return true;
    else return false;
}

int main() {
    int h, w; cin >> h >> w;
    int a, b; cin >> a >> b;

    // 가로로 널기
    bool check = dry(2*h, w, a, b);
    if(check) {
        cout << "YES";
        return 0;
    }
    // 세로로 널기.
    check = dry(2*h, w, b, a);
    if(check) cout << "YES";
    else cout << "NO";
}