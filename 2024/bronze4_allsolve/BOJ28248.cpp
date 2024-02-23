#include <iostream>

using namespace std;

int main() {
    int a, b; cin >> a >> b;

    int score = a*50 - b*10;
    score += (a > b) ? 500 : 0;
    cout << score;
}