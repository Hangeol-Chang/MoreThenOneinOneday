#include <iostream> 

using namespace std;

int main() {
    int a, b, c, d; cin >> a >> b >> c >> d;
    int na = a * b;
    int nb = c * d;
    
    if(     na > nb)    cout << "M";
    else if(na < nb)    cout << "P";
    else                cout << "E";
}