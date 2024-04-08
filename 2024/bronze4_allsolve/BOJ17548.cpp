#include <iostream>

using namespace std;

int main() {
    string inp; cin >> inp;

    int c = 0;
    for(char a : inp) if(a == 'e') ++c;

    cout << "h";
    for(int i = 0; i < 2*c; i++) cout << 'e';
    cout << 'y';
}