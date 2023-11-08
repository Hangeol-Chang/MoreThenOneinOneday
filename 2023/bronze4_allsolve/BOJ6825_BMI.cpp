#include <iostream>

using namespace std;

int main() {
    double h, w;
    cin >> w >> h;
    double bmi = w / (h*h);
    
    if(bmi < 18.5) cout << "Underweight";
    else if ( bmi <= 25) cout << "Normal weight";
    else cout << "Overweight";
}