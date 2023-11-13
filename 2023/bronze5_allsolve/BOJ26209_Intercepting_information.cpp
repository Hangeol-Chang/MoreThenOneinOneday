#include <iostream>

using namespace std;

int main() {
    bool pass = true;
    for(int i = 0; i < 8; i++) {
        int tmp;
        cin >> tmp;
        if(tmp == 9) pass = false;
    }
    
    if(pass) cout << "S";
    else cout << "F";
}