#include <iostream>
#include <vector>
// #include <algorithm>

using namespace std;

int main() {
    int t = 0;
    while(true) {
        int N; cin >> N;
        if(N == 0) return 0;
        
        vector<int> map;
        for(int i = 0; i < N; i++) {
            int tmp; cin >> tmp;
            map.push_back(tmp);
        }
        // sort(map.begin(), map.end());

        double ans = 0.0;
        if(N % 2 == 1) ans = map[N/2] * 1.0;
        else ans = (map[N/2 -1] + map[N/2]) / 2.0;
        
        printf("Case %d: %.1f\n", ++t, ans);
    }
}