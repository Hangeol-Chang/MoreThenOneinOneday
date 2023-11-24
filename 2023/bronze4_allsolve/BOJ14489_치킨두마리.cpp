#include <iostream>

using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    int sum = a + b;
    if(sum >= 2 * c) cout << sum - 2 * c;
    else cout << sum;
}