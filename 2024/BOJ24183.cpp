#include <iostream>

using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    // g / m^2
    
    double size1 = 0.229 * 0.324 * 2;
    double size2 = 0.297 * 0.420 * 2;
    double size3 = 0.210 * 0.297;

    double ans = a*size1 + b*size2 + c*size3;
    printf("%.6f\n", ans);
}