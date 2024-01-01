#include <iostream>

using namespace std;

int main() {
    int T;
    cin >> T;
    for(int t = 1; t <= T; t++) {
        int N, s, day; cin >> N >> s >> day;
        int distLimit = day * s;

        int ans = 0;
        for(int n = 0; n < N; n++) {
            int dist, cost;
            cin >> dist >> cost;
            if(dist <= distLimit) ans += cost;
        }

        printf("Data Set %d:\n%d\n\n", t, ans);
    }
}