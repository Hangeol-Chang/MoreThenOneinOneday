#include <iostream>
#include <limits>

// gg

using namespace std;

int n;
int **map;
int *dp;
int fullvisit;

int circuit2(int nowloc, int visited) {
    cout << "\nnowloc : " << nowloc << " visited : " << visited << "\n";
    if(nowloc == 0) {
        if(visited == fullvisit) return -1;
        else return -2;
    }

    if(dp[visited] != 0) {
        cout << "return" << visited << " " << dp[visited] << "\n";
        return dp[visited];
    }

    //저장되지 않았으면, dp[visited]를 구해야 함.
    int mincost = numeric_limits<int>::max();
    for(int i = 0; i < n; i++) {

        if(!(visited & 1<<i)) {
            if(dp[visited] == 0) {
                int tmpcost = circuit2(i, visited | 1<<i);

                dp[visited] = map[nowloc][i] + circuit2(i, visited | 1<<i);
            }
            mincost = min(mincost, dp[visited]);
        }
        cout << mincost << "\n";

        for(int i = 0; i <= fullvisit; i++) {
            cout << dp[i] << " ";
        }
        cout << "\n";
    }
    return mincost;
}

int main() {
    cin >> n;

    map = new int *[n];
    for(int i = 0 ; i < n; i++) {
        fullvisit = fullvisit | 1<<i;
        map[i] = new int[n];

        for(int j = 0; j < n; j++) cin >> map[i][j];
    }
    dp = new int[fullvisit+1];
    fill_n(dp, fullvisit+1, 0);
    // 입력 완료.
    
    // for(int i = 0; i < n; i++) {
    //     for(int j = 0; j < n; j++) {
    //         cout << map[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    // for(int i = 0; i < n; i++)
    //     if(map[i][0] != 0) {
    //         int bit = 1<<i;
    //         dp[fullvisit - bit] = map[i][0];
    //     }
    
    // cout << "\nDebug\n";
    // for(int i = 0; i < fullvisit; i++) {
    //     cout << dp[i]<< " ";
    //     if( i % 20 == 0) cout <<endl;
    // }
    cout << circuit2(0, 0);
}

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

*/