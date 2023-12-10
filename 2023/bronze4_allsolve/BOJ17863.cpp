#include <iostream>
#include <cstring>

using namespace std;

int main() {
    string number; cin >> number;

    string parseNum = number.substr(0, 3);
    string con = "555";
    if(con == parseNum) cout << "YES";
    else cout << "NO";
}