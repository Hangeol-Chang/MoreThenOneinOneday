#include <iostream>

using namespace std;

/*
    계단 M개.
    에스컬 속도 S.
    걷는 속도 G.

    L / A
    R / B
*/

int main() {
    int M, S, G, L, R;
    double A, B;
    cin >> M >> S >> G >> A >> B >> L >> R;

    double left  = M*1.0 / G + L / A;
    double right = M*1.0 / S + R / B;

    if(left > right) cout << "latmask";
    else cout << "friskus";
}