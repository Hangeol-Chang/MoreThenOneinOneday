#include <iostream>

using namespace std;

int main() {
    int a, p; cin >> a >> p;
    a *= 7;
    p *= 13;

    if(a > p) cout << "Axel";
    else if (a < p) cout << "Petra";
    else cout << "lika";
}