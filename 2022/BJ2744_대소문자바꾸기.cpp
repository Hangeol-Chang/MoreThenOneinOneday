#include <iostream>
#include <string>
using namespace std;

int main() {
    string ini;
    cin >> ini;

    for(char c : ini) {
        if( c <= 'Z') cout << (char)(c+32);
        else cout << (char)(c-32);
    }
}