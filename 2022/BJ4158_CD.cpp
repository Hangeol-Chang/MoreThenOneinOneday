#include <iostream>

using namespace std;

int binarysearch(int arr[], int st, int ed, int goal) {
    int mid = (st+ed)/2;
    while (st < ed) {
        if(arr[mid] < goal) st = mid+1;
        else if(arr[mid] > goal) ed = mid-1;
        else return mid;
    }
    return ed;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    do {
        int N, M;
        cin >> N >> M;
        if(N == 0 && M == 0) return 0;

        int a[N];
        int b[M];

        for(int i = 0; i < N; i++) cin >> a[i];
        for(int i = 0; i < M; i++) cin >> b[i];
        
        int apointer = 0;
        int bpointer = 0;

        int ans = 0;
        while( apointer < N && bpointer < M) {
            if     (a[apointer] < b[bpointer]) apointer = binarysearch(a, apointer, N, b[bpointer]);
            else if(a[apointer] > b[bpointer]) bpointer = binarysearch(b, bpointer, M, a[apointer]);

            if (a[apointer] == b[bpointer]){
                ans ++;
            }
            
            apointer++;
            bpointer++;
        }
        cout << ans << endl;

    } while(true);
}