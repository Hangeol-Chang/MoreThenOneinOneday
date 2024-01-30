#include <iostream>
#include <vector>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        int N; cin >> N;
        vector<int> map(N+1, 0);
        for(int i = 1; i <= N; i++) cin >> map[i];

        cout << "Denominations:";
        for(auto it = map.begin() + 1; it != map.end(); it++) cout << " " << *it;
        cout << "\n";

        int good = true;
        for(int i = 0; i < N; i++) {
            if(map[i] * 2 > map[i+1]) {
                goto fail;
            }
        }

        cout << "Good coin denominations!\n\n";
        continue;
        fail:
            cout << "Bad coin denominations!\n\n";
    }
}