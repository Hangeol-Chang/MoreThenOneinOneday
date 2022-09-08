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

    // in에 입력받은 것들을 셈.
    map<int, int> in;
    int maxval = 0;
    // c에 원래 것을 입력받음.
    int c[n];
    for(int i = 0; i < n; i++) {
        cin >> c[i];
        maxval = max(c[i], maxval);

        if(in.count(c[i])) in[c[i]] += 1;
        else in.insert({c[i], 1});
    }

    // 각 수가 클릭할 수를 체크
    int ans[maxval+1] = {0};
    fill_n(ans, maxval+1, -1);
    
    for(pair<int, int> data : in) {
        int i = data.first;

        for(int k = 1; k*k <= i && k < i; k++) {
            if(i % k == 0) {
                if(i/k != k)
                    ans[i] += in[k] + in[i/k];
                else 
                    ans[i] += in[k];
            }
        }
        // ans[i] += data.second - 1;
        if(ans[i] < 0) ans[i] = 0;
    }

    // for(int i = 0; i < n; i++) {
    //     for(int k = 1; k*k <= c[i]; k++) {
    //         if(c[i] % k == 0)  {
    //             if(c[i]/k != k)
    //                 ans[i] += in.count(k) + in.count(c[i]/k);
    //             else
    //                 ans[i] += in.count(k);
    //         }
    //     }
    // }

    for(int i = 0; i < n; i++) cout << ans[c[i]] << endl;
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