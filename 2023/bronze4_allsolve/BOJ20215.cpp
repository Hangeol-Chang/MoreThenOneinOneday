#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int w, h;
    cin >> w >> h;
    
    double p1 = w * 1.0 + h;
    double p2 = sqrt(w*w + h*h);
    
    printf("%.8f", p1 - p2);
}
