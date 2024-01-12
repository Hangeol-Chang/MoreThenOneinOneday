#include <iostream>

using namespace std;

int main() {
    int C, R; cin >> C >> R;
    R -= 1;

    int r = 0;
    int c = -1;
    // start [r-1, 0]
    int idx = 0;
    // 0 > c + 1
    // 1 > r - 1
    // 2 > c - 1
    // 3 > r + 1

    while(true) {
        switch(idx) {
        case 0 :
            if(C == 0) goto outer;
            c += C;
            C--;
            break;
        case 1 :
            if(R == 0) goto outer;
            r += R;
            R--;
            break;
        case 2 :
            if(C == 0) goto outer;
            c -= C;
            C--;
            break;
        case 3 :
            if(R == 0) goto outer;
            r -= R;
            R--;
            break;
        }
        // cout << idx << " " << r << " " << c << "\n";
        idx = (idx + 1) % 4;
    }
    outer:;
    cout << c << " " << r;
}