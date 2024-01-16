#include <iostream>

using namespace std;

int main() {
    int i1, i2; cin >> i1 >> i2;
    int a = 100 - i1;
    int b = 100 - i2;
    int c = 100 - (a + b);
    int d = a*b;
    int q = d / 100;
    int r = d % 100;

    printf("%d %d %d %d %d %d\n%d %d", a, b, c, d, q, r, c+q, r);
}