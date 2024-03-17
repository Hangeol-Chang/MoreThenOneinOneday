#include <iostream>
#include <cstring>

using namespace std;

int main() {
    string a; cin >> a;
    int mm = stoi(a.substr(5, 2));
    int dd = stoi(a.substr(8, 9));

    if(mm < 9) cout << "GOOD";
    else if(mm > 9) cout << "TOO LATE";
    else {
        if(dd <= 16) cout << "GOOD";
        else cout << "TOO LATE";
    }
}