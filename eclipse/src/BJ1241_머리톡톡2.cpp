#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    
    int n;
    cin >> n;

    map<int, int> in;
    int c[n];
    for(int i = 0; i < n; i++) {
        cin >> c[i];

        if(in.count(c[i])) in[c[i]] += 1;
        else in.insert({c[i], 1});
    }

    int ans[n] = {-1};
    for(int i = 0; i < n; i++) {
        for(int k = 1; k*k <= c[i]; k++) {
            if(c[i] % k == 0)  {
                if(c[i]/k != k)
                    ans[i] += in.count(k) + in.count(c[i]/k);
                else
                    ans[i] += in.count(k);
            }
        }
    }

    for(int i = 0; i < n; i++)
        cout << ans[i] << endl;
}