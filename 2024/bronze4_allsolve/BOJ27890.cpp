#include <iostream>

using namespace std;

int main() {
    int x, N; cin >> x >> N;

    int time = 0;
    while(time < N) {
        if(x % 2 == 0) {
            x = (x/2) ^ 6;
        }
        else {
            x = (2*x) ^ 6;
        }
        ++time;
    }
    cout << x;
}