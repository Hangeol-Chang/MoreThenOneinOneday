#include <iostream>

using namespace std;

int main() {
    int y1, m1, d1; cin >> y1 >> m1 >> d1;
    int y2, m2, d2; cin >> y2 >> m2 >> d2;

    int y = y2 - y1;
    int m = m2 - m1;
    int d = d2 - d1;

    // 만 나이
    // 한국 나이 y+1
    // 연 나이 y
    int my = (m > 0 || (m == 0 && d >= 0)) ? 0 : -1;

    cout << my+y << "\n" << y+1 << "\n" << y;
}