#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;
    
    int arr[n];
    for(int i = 0; i < n; i++){ cin >> arr[i]; }
    
    int l = 0;
    int r = 0;

    int ans = 10000000;
    int girlcount = 1 - arr[0];

    while(r < n) {
        while(arr[l] == 1) {
            girlcount -= 1 - arr[l++];
        }
        while(girlcount < k && r < n) {
            girlcount += 1 - arr[++r];
        }

        if(girlcount == k){
            ans = min(ans, (r-l+1)-k);
            cout << l << " " << r << + " " << ans << endl;
            girlcount -= 1 - arr[l++];
        }
    }
    if(ans == 10000000) cout << "NIE";
    else                cout << ans;
}

/*
8 5
0 1 1 1 1 1 1 0

30 10
0 1 0 0 1 1 0 1 0 0 0 0 1 1 1 1 0 1 0 1 1 1 1 1 0 1 0 1 0 1

30 10
0 1 0 0 1 1 0 1 0 0 0 0 1 1 1 1 0 1 0 1 1 1 1 1 0 1 0 1 0 0
5 5
0 0 0 0 0

5 5
0 0 1 0 0

8 3
0 1 0 1 0 1 1 1

8 3
0 1 0 1 0 1 0 0

5 1
1 1 1 0 0

5 2

*/