#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    do {
        int N, M;
        cin >> N >> M;
        if(N == 0 && M == 0) return 0;

        unordered_set<int> pi;

        for(int i = 0; i < N; i++) {
            int num;
            cin >> num;
            pi.insert(num);
        }

        int ans = 0;
        for(int i = 0; i < M; i++){
            int num;
            cin >> num;
            if(pi.find(num) != pi.end()) ans++;
        }
        cout << ans << endl;

    } while(true);
}