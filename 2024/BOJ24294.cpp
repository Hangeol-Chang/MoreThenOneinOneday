#include <iostream>

using namespace std;

int main() {
    int w1, h1, w2, h2;
    cin >> w1 >> h1 >> w2 >> h2;
    cout << w1 + h1*2 + w2 + h2*2 + 4 +abs(w2 - w1);
}