#include <iostream>

using namespace std;

int main() {
    int s, a, b; cin >> s >> a >> b;

    int cost = 250;
    int height = a;

    while(height < s) {
        cost += 100;
        height += b;
    }
    cout << cost;
}