#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> map(3, 0);
    cin >> map[0] >> map[1] >> map[2];

    sort(map.begin(), map.end());
    if(map[0] + map[1] == map[2]) cout << 1;
    else if (map[0] * map[1] == map[2]) cout << 2;
    else cout << 3;
}