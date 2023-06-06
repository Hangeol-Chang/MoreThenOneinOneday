#include <iostream>
using namespace std;

int main() {
    long long x, y, f, c, x1, y1, x2, y2;
    cin >> x >> y >> f >> c >> x1 >> y1 >> x2 >> y2;

    // 이 x까지 종이가 겹쳐 있음.
    long long doubleX = min(f, (x - f));

    long long paint1 = ((y2 - y1) * (x2 - x1)) * (c + 1);
    long long paint2 = (min(doubleX, x2) - x1) * (y2 - y1) * (c + 1);
    if(paint2 < 0) paint2 = 0;

    long long area = x * y;
    cout << area - (paint1 + paint2);
}