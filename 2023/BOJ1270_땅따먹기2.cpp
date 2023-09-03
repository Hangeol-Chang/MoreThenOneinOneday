#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

    int T; cin >> T;
    int N;

    unordered_map<long long, int> mm;
    long long tmpnum, occupied;

    for(int t = 1; t <= T; t++) {
        mm.clear();
        occupied = 0;

        cin >> N;

        for(int i = 0; i < N; i++) {
            cin >> tmpnum;

            if(!occupied) {
                mm[tmpnum]++;
                if(mm[tmpnum] >= N / 2 + 1) occupied = tmpnum;
            }
        }

        if(occupied)    cout << occupied << "\n";
        else            cout << "SYJKGW" << "\n";
    }
    return 0;
}