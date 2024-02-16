#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    string inp; cin >> inp;
    vector<char> characters = {'M', 'O', 'B', 'I', 'S'};

    vector<int> check(5, 0);

    for(char c : inp) {
        auto it = find(characters.begin(), characters.end(), c);
        if(it != characters.end()) check[it - characters.begin()] = 1;
    }

    bool canMake = true;
    for(int n : check) 
        if(!n) {
            canMake = false;
            break;
        }

    if(canMake) cout << "YES";
    else cout << "NO";
}