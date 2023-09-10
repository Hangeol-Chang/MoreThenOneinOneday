#include <iostream>
#include <string>

using namespace std;

int main() {
    string inp;
    cin >> inp;
    int y = stoi(inp.substr(0, 4));
    int m = stoi(inp.substr(5, 7));
    int d = stoi(inp.substr(8, 10));

    int dDate; cin >> dDate;
    
    d += dDate;
    while(d > 30) {
        d -= 30;
        m += 1;
    }
    while(m > 12) {
        m -= 12;
        y += 1;
    }

    printf("%04d-%02d-%02d", y, m, d);
}