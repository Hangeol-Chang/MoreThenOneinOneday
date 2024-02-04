#include <iostream>

using namespace std;

int main() {
    string s;
    getline(cin, s);
    int a = s[0] - '0';
    int b = s[4] - '0';
    int c = s[8] - '0';
    if(a + b == c) cout << "YES";
    else cout << "NO";
}