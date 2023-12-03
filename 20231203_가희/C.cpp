#include <iostream>

using namespace std;

int main() {
    int p, r; cin >> p >> r;
    double x = p*1.0 / r;

    if(x < 0.2) cout << "weak";
    else if(x < 0.4) cout << "normal";
    else if(x < 0.6) cout << "strong";
    else cout << "very strong";
}