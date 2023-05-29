#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool pairCmp(pair<int, int> a, pair<int, int> b) {
    return a.second < b.second;
}

int main() {
    int N, M;
    cin >> N >> M;

    vector<int> costs;
    for(int i = 0; i < M; i++) {
        int tmp;
        cin >> tmp;
        costs.push_back(tmp);
    }

    sort(costs.begin(), costs.end());

    vector<pair<int, int>> earns;

    for(vector<int>::iterator it = costs.begin(); it != costs.end(); it++) {
        int c = costs.end() - it;
        int sellCount = min(c, N);

        earns.push_back(make_pair(*it, sellCount * *it));
    }

    sort(earns.rbegin(), earns.rend(), pairCmp);

    // for(vector<pair<int, int>>::iterator it = earns.begin(); it != earns.end(); it++) {
    //     cout << it->first << " " << it->second << endl;
    // }

    cout << earns[0].first << " " << earns[0].second;
}