#include <iostream>

using namespace std;

int main() {
    long long p1, q1, p2, q2; cin >> p1 >> q1 >> p2 >> q2;

    long long up = p1 * p2;
    long long un = q1 * q2;

    // cout << up << " " << un << endl;
    if( up % un == 0 && (up / un) % 2  == 0 ) cout << 1;
    else cout << 0;
}