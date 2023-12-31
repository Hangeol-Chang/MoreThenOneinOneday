#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    vector<int> m;
    for(int i = 0; i < 3; i++) {
        int t; cin >> t;
        m.push_back(t);
    }
    sort(m.begin(), m.end());
    cout << m[1];    
}