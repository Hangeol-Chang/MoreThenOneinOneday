#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;
    
    for(int i = 0; i < N; i++) {
        double tot = 1.0;
        for(int j = 0; j < 3; j++) {
            double m; cin >> m;
            tot *= m;
        }
        printf("$%.2f\n", tot);
    }
}