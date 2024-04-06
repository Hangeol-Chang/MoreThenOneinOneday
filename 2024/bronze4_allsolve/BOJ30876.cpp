#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;
    int x = 1001, y = 1001;
    for(int n = 0; n < N; n++) {
        int xin, yin; cin >> xin >> yin;
        if(yin < y) {
            x = xin;
            y = yin;
        }
    }
    cout << x << " " << y;
}