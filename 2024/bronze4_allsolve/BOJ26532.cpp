#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int a, b; cin >> a >> b;
    double c = a * b / 4840.0 / 5;
    printf("%d", (int)ceil(c));
}