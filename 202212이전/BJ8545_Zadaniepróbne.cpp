#include<iostream>

using namespace std;

int main() {
    string ini;
    cin >> ini;
    
    for(int i = ini.length()-1; i >= 0; i--) {
        cout << ini[i];
    }
}