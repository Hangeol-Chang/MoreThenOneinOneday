#include <iostream>
#include <vector>

using namespace std;

int main() {
    int R, C;
    cin >> R >> C;

    vector<vector<char>> map(R, vector<char>(C, 0));

    for(int r = 0; r < R; r++) {
        string s;
        cin >> s;
        
        for(int c = 0; c < C; c++) map[r][c] = s[c];
    }
    
    for(auto it = map.begin(); it != map.end(); it++) {
        for(auto it2 = it->rbegin(); it2 != it->rend(); it2++) cout << *it2;
        cout << "\n";
    }
}