#include <iostream>

using namespace std;

int main() {
    
    while(true) {
        double x, y; cin >> x >> y;
        if(x == 0.0 || y == 0.0) cout << "AXIS\n";
        else {
            
            if(x > 0.0) {
                if(y > 0.0) cout << "Q1\n";
                else cout << "Q4\n";
            }
            else {
                if(y > 0.0) cout << "Q2\n";
                else cout << "Q3\n";
            }
        }
        if(x == 0.0 && y == 0.0) return 0;
    }
}