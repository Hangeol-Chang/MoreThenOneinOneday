#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N; cin >> N;
    if(N == 0) {
        cout << 0;
        return 0;
    }
    double per = N * 0.15;
    int cutC = (int)(per + 0.5);

    vector<int> difficults(N, 0);
    for(int i = 0; i < N; i++) cin >> difficults[i];

    sort(difficults.begin(), difficults.end());

    long long sum = 0;
    for(vector<int>::iterator it = difficults.  begin() + cutC; it != difficults.end() - cutC; it++) 
        sum += *it; 
    
    per = sum * 1.0 / (N - 2*cutC);
    int ans = (int)(per + 0.5);
    cout << ans;
}