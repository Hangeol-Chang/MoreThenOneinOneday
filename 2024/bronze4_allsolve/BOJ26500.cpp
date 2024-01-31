#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        double a, b; cin >> a >> b;
        double absv = a - b;
        if(absv < 0) absv *= -1;
        printf("%.1f\n", absv);
    }
}