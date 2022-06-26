#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int T;
    cin >> T;
    
    for(int t = 1; t <= T; t++) {
        int N;
        cin >> N;

        int arr[N];
        for(int i = 0; i < N; i++) cin >> arr[i];

        sort(arr, arr + N);
        int ans = 0;        
        for(int i = 0; i < N; i++){
            int l = i;
            int r = N-1;

            int target = 202021 - arr[i];
            int mid;
            while(l < r) {
                mid = (l+r)/2;
                // cout << "l r mid " << l << " " << r << " " << mid << endl;
                if(arr[mid] < target) l = mid+1;
                else                   r = mid;
            }
            // cout << i << " r : " << r << ", arr[r] : " << arr[r] << ", target : " << target << endl;

            if(arr[r] == target)
                while(arr[r++] == target){
                    ans++;
                    // cout << "pass" << endl;
                }
        }
        cout << ans << endl;
    }
}
/*

3
4
101010 101010 101011 101011
5
100000 100000 100000 101011 101011
4
202021 0 1 202020

*/