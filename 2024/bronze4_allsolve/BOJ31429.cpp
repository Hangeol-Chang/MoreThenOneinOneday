#include <iostream>
#include <vector>
#define pp pair<int, int>

using namespace std;

int main() {
    vector<pair<int, int>> map(12, pair<int, int>(0, 0));

    map[1] = pp(12, 1600);
    map[2] = pp(11, 894);
    map[3] = pp(11, 1327);
    map[4] = pp(10, 1311);
    map[5] = pp(9, 1004);
    map[6] = pp(9, 1178);
    map[7] = pp(9, 1357);
    map[8] = pp(8, 837);
    map[9] = pp(7, 1055);
    map[10] = pp(6, 556);
    map[11] = pp(6, 773);

    int n; cin >> n;
    pp a = map[n];

    cout << a.first << " " << a.second;
}