#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    
    for(int t = 0; t < T; t++) {
        int C, R; cin >> C >> R;
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) 
                cout << "X";
            cout << "\n";
        }
        cout << "\n";
    }
}