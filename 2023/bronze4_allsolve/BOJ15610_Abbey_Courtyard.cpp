#include <iostream>
#include <cmath>

using namespace std;

int main() {
    long long a; cin >> a;
    double b = sqrt(a * 1.0);

    printf("%.8f\n", b * 4);
}