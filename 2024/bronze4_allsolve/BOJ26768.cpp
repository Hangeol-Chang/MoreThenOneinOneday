#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    unordered_map<char, int> map;
    
    map['a'] = '4';
    map['e'] = '3';
    map['i'] = '1';
    map['o'] = '0';
    map['s'] = '5';

    string inp; cin >> inp;

    for(int i = 0; i < inp.length(); i++) {
        if(map.find(inp[i]) != map.end()) {
            inp[i] = map[inp[i]];
        }
    }
    cout << inp;
}