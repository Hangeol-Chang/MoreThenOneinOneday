#include <iostream>

using namespace std;

int main() {
    double a;
    while(true) {
        cin >> a;
        if( a == 0 ) return 0;

        printf("%.2f\n", 1 + a + a*a + a*a*a + a*a*a*a);
    }
}