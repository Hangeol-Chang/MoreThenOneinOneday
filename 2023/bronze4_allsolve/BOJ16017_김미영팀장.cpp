#include <iostream>

using namespace std;

int main() {
    int a, b, c, d;
    cin >> a >> b >> c >> d;

    if(a/2 == 4 && d/2 == 4 && b == c) cout << "ignore";
    else cout << "answer";
}