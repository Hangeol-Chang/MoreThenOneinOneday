#include <iostream>

using namespace std;

int main() {
    int t1, e1, f1; cin >> t1 >> e1 >> f1;
    int t2, e2, f2; cin >> t2 >> e2 >> f2;

    int sum1 = 3 * t1 + 20 * e1 + 120 * f1;
    int sum2 = 3 * t2 + 20 * e2 + 120 * f2;

    if(sum1 > sum2) cout << "Max";
    else if(sum1 < sum2) cout << "Mel";
    else cout << "Draw";
}