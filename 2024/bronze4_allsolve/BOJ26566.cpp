#include <iostream>
#define PI 3.14159265359

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        int A1, P1; cin >> A1 >> P1;
        int R1, P2; cin >> R1 >> P2;

        double vs = A1*1.0 / P1;
        double vr = R1*R1*PI / P2;

        if(vs > vr) cout <<  "Slice of pizza\n";
        else cout << "Whole pizza\n";
    }
}