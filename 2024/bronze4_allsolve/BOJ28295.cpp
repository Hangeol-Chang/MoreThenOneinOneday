#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<char> dir = {'N', 'E', 'S', 'W'};
    
    int idx = 0;
    for(int i = 0; i < 10; i++) {
        int order; cin >> order;
        
        idx = (idx + order) % 4;
    }
    cout << dir[idx];
}