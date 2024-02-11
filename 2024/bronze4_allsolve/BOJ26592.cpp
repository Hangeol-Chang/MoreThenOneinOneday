#include <iostream> 

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        double a, b; cin >> a >> b;
        printf("The height of the triangle is %.2f units\n", a * 2 / b);
    }
}