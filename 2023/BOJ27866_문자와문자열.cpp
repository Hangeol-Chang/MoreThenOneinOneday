#include <iostream>

using namespace std;

int main() {
    char * str = new char[1001];
    int a;
    cin >> str >> a;
    cout << str[a - 1];
}