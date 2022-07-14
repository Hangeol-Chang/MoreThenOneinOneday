#include <iostream>

using namespace std;

int main() {
    string ini;
    do {
        getline(cin, ini);
        cout << ini << endl;
    }while(ini.length() > 0);
}