#include <iostream>

using namespace std;

int main() {
    while(true) {
        char c; cin >> c;
        switch(c) {
            case 'w' :
                cout << "chunbae";
                goto endP;
            case 'b' :
                cout << "nabi";
                goto endP;
            case 'g' :
                cout << "yeongcheol";
                goto endP;
            default:
                continue;
        }
    }
    endP:;
}