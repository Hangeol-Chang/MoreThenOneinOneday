#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int N, M;
    int *memories;
    int *shutcost;

    cin >> N >> M;

    memories = new int[N+1];
    shutcost = new int[N+1];
    int costsum = 0;

    for(int i = 1; i <= N; i++) cin >> memories[i];
    for(int i = 1; i <= N; i++) {
        cin >> shutcost[i];
        costsum += shutcost[i];
    }

    int dp[N+1][costsum + 1];
    
    for(int i = 0; i <= costsum; i++) dp[0][i] = 0;

    for(int i = 1; i <= N; i++ ) {
        for(int j = 0; j <= costsum; j++) {
            dp[i][j] = 0;

            if( j - shutcost[i] >= 0 ) 
                dp[i][j] = dp[i-1][j-shutcost[i]] + memories[i];

            dp[i][j] = max(dp[i][j], dp[i-1][j]);
        }
    }

    // for(int i = 0; i <= N; i++) {
    //     for(int j = 0; j <= costsum; j++){
    //         printf("%4d", dp[i][j]);
    //     }
    //     cout << endl;
    // }

    for(int i = 0; i <= costsum; i++) {
        if(dp[N][i] >= M) {
            cout << i << endl;
            return 0;
        } 
    }
}