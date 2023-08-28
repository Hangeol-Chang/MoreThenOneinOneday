#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b) {
    if(a.first == b.first) {
        return a.second < b.second;
    }
    return a.first < b.first;
}

vector<pair<int, int>> table;

int main() {
    int C, N;
    cin >> C >> N;
    
    for(int i = 0; i < N; i++) {
        int a, b; cin >> a >> b;
        table.push_back(pair<int, int>(a, b));
    }
    sort(table.begin(), table.end(), cmp);
    // 입력 완료.

    vector<int> dpTable;
    dpTable.push_back(0);
    
    // c까지 dp테이블 계산.
    int c = 0;
    int earn = 0;
    while(earn < C) {
        ++c;

        int candis = dpTable[c-1];
        for(vector<pair<int, int>>::iterator it = table.begin(); it != table.end(); it++) {
            // cout << it->first << "\n";

            if(it->first > c) goto outer;
            int tmpcan = dpTable[c - it->first] + it->second;

            candis = tmpcan > candis ? tmpcan : candis;
        }
        outer:;
        
        dpTable.push_back(candis);
        earn = candis;
    }
    
    // cout << "----\n";
    // for(vector<int>::iterator it = dpTable.begin(); it != dpTable.end(); it++) {
    //     cout << *it << endl;
    // }
    cout << dpTable.size() - 1;
}