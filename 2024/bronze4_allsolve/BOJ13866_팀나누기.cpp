#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> lv(4, 0);
    for(auto it = lv.begin(); it != lv.end(); it++) cin >> *it;
    // sort(lv.begin(), lv.end());
    
    cout << abs((lv[3] + lv[0]) - (lv[1] + lv[2]));
}