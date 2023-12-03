#include <iostream>
#include <vector>

using namespace std;

int main() {
    int l, r;
    cin >> l >> r;
    int fullBeat = l * r;
    
    vector<int> map(fullBeat + 1, 0);

    int c = 0;
    while(c <= fullBeat) {
        c += r;
        map[c] += 1;
    }
    
    c = 0;
    while(c <= fullBeat) {
        c += l;
        map[c] += 2;
    }
    
    for(auto it = map.begin(); it != map.end(); it++) {
        if(*it) cout << *it;
    }
}