#include <iostream>
#include <algorithm>

using namespace std;

// 시간초과
int calced[1000001];

int main() {
    int n;
    cin >> n;
    
    int c[n];
    int sorted[n];

    int ans[n] = {0};

    for(int i = 0; i < n; i++) {
        cin >> c[i];
        sorted[i] = c[i];
    }
    sort(sorted, sorted + n);

    for(int i = 0; i < n; i++) {
        if( calced[c[i]] != 0 ) {
            ans[i] = calced[c[i]];
            continue;
        }

        int count = 0;
        int j = 0;
        while(j < n && c[i] >= sorted[j]) {
            if(c[i] % sorted[j] == 0) count++;
            j++;
        }
        calced[c[i]] = count-1;
        ans[i] = count-1;
    }
    
    for(int i = 0; i < n; i++) cout << ans[i] << endl;
}