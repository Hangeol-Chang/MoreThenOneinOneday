#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int a, b; cin >> a >> b;
    double M = (b - a) * 1.0 / 400;
    
    printf("%.6f", 1.0 / (1 + pow(10, M)));
}
