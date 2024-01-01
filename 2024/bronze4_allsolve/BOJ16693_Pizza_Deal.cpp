#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double A, R;
    int P1, P2;
    cin >> A >> P1 >> R >> P2;

    double v1 = A / P1;
    double v2 = 3.14159265359 * R * R / P2;

    // printf("%.10f\n%.10f", v1, v2);
    if( v1 > v2 ) cout << "Slice of pizza";
    else cout << "Whole pizza";
}