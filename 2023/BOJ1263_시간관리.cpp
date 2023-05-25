#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool taskSortFunc(pair<int, int> a, pair<int, int> b) {
    if(a.second != b.second) return a.second > b.second;
    return a.first > b.first;
}

// 제일 먼저 끝내야되는 일을, 제일 먼저 시작시킴.
int main() {
    int N;
    vector<pair<int, int>> tasks;

    cin >> N;
    for(int i = 0; i < N; i++) {
        int f, s;
        cin >> f >> s;
        
        tasks.push_back(make_pair(f, s));
    }

    sort(tasks.begin(), tasks.end(), taskSortFunc);
    
    // 최대시간을 잡고 시작.
    int time = tasks[0].second;
    for(vector<pair<int, int>>::iterator it = tasks.begin(); it != tasks.end(); it++) {
        // 이번 일을 끝내야되는 max시간을 잡음.
        time = min(it->second, time);

        // task에 필요한 시간을 뺌.
        time -= it->first;
    }
    
    cout << max(-1, time);
}