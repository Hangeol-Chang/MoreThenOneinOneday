#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int main() {
    vector<vector<int>> map(10, vector<int>(20, 0));
    
    int N; cin >> N;
    for(int n = 0; n < N; n++) {
        string seat;
        cin >> seat;
        int row = seat[0] - 'A';
        int col = stoi(seat.substr(1)) - 1;
        map[row][col] = 1;
    }

    for(auto it = map.begin(); it != map.end(); it++) {
        for(auto it2 = it->begin(); it2 != it->end(); it2++) {
            if(*it2) cout << "o";
            else cout << ".";
        }
        cout << "\n";
    }
}