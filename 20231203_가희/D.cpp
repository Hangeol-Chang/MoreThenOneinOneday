#include <iostream>

using namespace std;

int main() {
    int a;
    string lv;
    cin >> a >> lv;

    if(lv[0] == 'm') cout << 0;
    else if(lv[0] == 'b') cout << a * 200;
    else if(lv[0] == 'c') cout << a * 400;
    else if(lv[0] == 'g') cout << a * 600;
    else cout << a * 1000;
}