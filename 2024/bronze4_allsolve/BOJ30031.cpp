#include <iostream>
#include <unordered_map>

using namespace std;

int main() {

    unordered_map<int, int> table = {{136 , 1000}, {142, 5000}, {148, 10000}, {154, 50000}};

    int N; cin >> N;
    int ans = 0;
    for(int n = 1; n <= N; n++) {
        int w, h; cin >> w >> h;
        auto it = table.find(w);
        ans += it->second;
    }
    cout << ans;
}