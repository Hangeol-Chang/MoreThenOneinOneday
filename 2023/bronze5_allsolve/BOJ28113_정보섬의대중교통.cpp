#include <iostream>

using namespace std;

int main() {
    int n, a, b;
    cin >> n >> a >> b;

    if(a == b) cout << "Anything";
    else if(a < b) cout << "Bus";
    else cout << "Subway";
}