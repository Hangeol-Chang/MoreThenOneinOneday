#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    
    int n;
    cin >> n;

    int maxval = 0;
    // c에 원래 것을 입력받음.
    vector<int> c(n);

    for(int i = 0; i < n; i++) {
        cin >> c[i];
        maxval = max(c[i], maxval);
    }

    vector<int> count(maxval+1);
    for(int num : c) count[num]++;

    vector<int> ans(n);
    for(int i = 0; i < n; i++) {
        for(int k = 1; k*k <= c[i]; k++) {
            if(c[i] % k == 0) {
                if(c[i]/k != k)
                    ans[i] += count[k] + count[c[i]/k];
                else 
                    ans[i] += count[k];
            }
        }
    }

    for(int num : ans) cout << num - 1 << "\n";
}
/*

10
1
2
3
4
5
6
7
8
9
10


*/