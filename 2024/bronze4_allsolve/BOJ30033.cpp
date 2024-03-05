#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N; cin >> N;
    int ans = 0;
    vector<int> map(N, 0);

    for(int n = 0; n < N; n++) cin >> map[n];

    for(int plan : map) {
        int study; cin >> study;
        if(study >= plan) ++ans;
    }
    cout << ans;
}