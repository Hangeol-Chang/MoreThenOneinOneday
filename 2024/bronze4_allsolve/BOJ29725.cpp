#include <iostream>
#include <unordered_map>

using namespace std;

/*
    k : 0
    p : 1
    n : 3
    b : 3
    r : 5
    q : 9
*/
int main() {
    unordered_map<char, int> map = {
        {'k',  0}, {'K', 0},
        {'p', -1}, {'P', 1},
        {'n', -3}, {'N', 3},
        {'b', -3}, {'B', 3},
        {'r', -5}, {'R', 5},
        {'q', -9}, {'Q', 9},
    };
    
    int score = 0;
    for(int i = 0; i < 8; i++) {
        string line; cin >> line;
        for(char c : line) {
            if(c == '.') continue;

            auto it = map.find(c);
            score += it->second;
        }
    }
    cout << score;
    
}