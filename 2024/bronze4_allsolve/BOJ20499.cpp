#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

int main() {
    string inp;
    cin >> inp;

    vector<string> splited;

    istringstream iss(inp);
    string buffer;
    while(getline(iss, buffer, '/')) {
        splited.push_back(buffer);
    }

    int k = stoi(splited[0]);
    int d = stoi(splited[1]);
    int a = stoi(splited[2]);

    if(d == 0 || k + a < d) cout << "hasu";
    else cout << "gosu";
}