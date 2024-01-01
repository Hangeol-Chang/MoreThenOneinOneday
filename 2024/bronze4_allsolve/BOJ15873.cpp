#include <iostream>
#include <cstring>

using namespace std;

int main() {
    string inp;
    cin >> inp;
    
    if(inp[1] == '0') cout << stoi(inp.substr(0, 2)) + stoi(inp.substr(2));
    else cout << (inp[0] - '0') + stoi(inp.substr(1));
}