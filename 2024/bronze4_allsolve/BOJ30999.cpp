#include <iostream>

using namespace std;

int main() {
    int N, M; cin >> N >> M;

    int ans = 0;
    for(int n = 0; n < N; n++) {
        string inp; cin >> inp;
        int good = 0;
        for(char c : inp) if(c == 'O') ++good;
        
        if(good > M/2) ++ans;
    }
    cout << ans;
}