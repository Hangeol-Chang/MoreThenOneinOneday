#include <iostream>

using namespace std;

int main() {
    int cost; cin >> cost;

    double fee = 25 + 0.01 * cost;
    if(fee < 100.0) fee = 100.0;
    if(fee > 2000.0) fee = 2000.0;
    cout << fee;
}