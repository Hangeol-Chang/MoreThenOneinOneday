#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N; cin >> N;
    vector<int> per(3, 0);
    for(int i = 0; i < 3; i++) cin >> per[i];
    for(int i = 0; i < 3; i++)
        if(per[i] > N)
            per[i] = N;

    int ans = 0;
    for(int c : per) ans += c;
    cout << ans;
}