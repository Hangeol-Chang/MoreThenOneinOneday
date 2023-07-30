#include <iostream>

using namespace std;

int main() {
    string a;
    cin >> a;

    for(char c : a) {
        printf("%c", c-32);
    }    
}