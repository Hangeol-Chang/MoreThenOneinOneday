#include <iostream>
#include <algorithm>

using namespace std;


// 202021
// 20202021
// 2020_2021

int targets[] = {202021, 20202021, 
                202002021, 
                202012021, 
                202022021,
                202032021,
                202042021,
                202052021,
                202062021,
                202072021,
                202082021,
                202092021};

int main() {
    int T;
    cin >> T;
    
    for(int t = 1; t <= T; t++) {
        int N;
        cin >> N;

        int arr[N];
        for(int i = 0; i < N; i++) cin >> arr[i];

        sort(arr, arr + N);
        long ans = 0;        
        for(int i = 0; i < N; i++){
            int l = i;
            int r = N-1;

            // 나올 수 있는 모든 결과수에 대해 이분탐색 진행.
            for(int fulltarget : targets){
                int target = fulltarget - arr[i];

                int mid;
                while(l < r) {
                    mid = (l+r)/2;
                    // cout << "l r mid " << l << " " << r << " " << mid << endl;
                    if(arr[mid] < target) l = mid+1;
                    else                   r = mid;
                }
                // cout << i << " r : " << r << ", arr[r] : " << arr[r] << ", target : " << target << endl;
                
                if(arr[r] == target)
                    while(r < N && arr[r++] == target)
                        ans++;
            }
        }
        cout << ans << endl;
    }
}
/*
1
5
202020 1 1 1 1

1
5
1 202020 202020 202020 202020

1
5
0 202021 202021 202021 20202021

3
4
101010 101010 101011 101011
5
100000 100000 100000 101011 101011
4
202021 0 1 202020

*/