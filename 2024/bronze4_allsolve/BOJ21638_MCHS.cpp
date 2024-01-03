#include <iostream>

using namespace std;

int main() {
    int t1, w1, t2, w2; cin >> t1 >> w1 >> t2 >> w2;

    if(t2 < 0 && w2 >= 10) { 
        cout << "A storm warning for tomorrow! Be careful and stay home if possible!";
        goto outP;
    }
    if(t2 < t1) {
        cout << "MCHS warns! Low temperature is expected tomorrow.";
        goto outP;
    }
    if(w2 > w1) {
        cout << "MCHS warns! Strong wind is expected tomorrow.";
        goto outP;
    }

    cout << "No message";

    outP:;
}