#include <iostream>

using namespace std;

int main() {
    int R, C;
    cin >> R >> C;
    
    for(int r = 0; r < R; r++) {
        for(int c = 0; c < C; c++) {
            cout << "*";
        }
        cout << "\n";
    }
}