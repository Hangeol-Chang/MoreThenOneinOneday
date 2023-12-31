#include <iostream>
#include <cmath>
#define PI 3.14159265359

using namespace std;

int main() {
    double area; cin >> area;
    printf("%.10f", 2 * PI * sqrt(area / PI));
}