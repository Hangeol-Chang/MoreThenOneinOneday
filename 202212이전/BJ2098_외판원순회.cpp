#include <iostream>
#include <limits>

#define INF 400000000
// dp로 품.
// 시간초과

using namespace std;

int n;
int map[16][16];
int dp[16][1<<16];
int fullvisit;

int circuit2(int nowloc, int visited) {
    if(visited == fullvisit) {
        if(map[nowloc][0] == 0) return INF;
        return map[nowloc][0];
    }
    if(dp[nowloc][visited] != 0) return dp[nowloc][visited];

    //저장되지 않았으면, dp[visited]를 구해야 함.
    dp[nowloc][visited] = INF;
    for(int i = 0; i < n; i++) {
        if((visited & 1<<i) > 0 || map[nowloc][i] == 0) continue;
        
        dp[nowloc][visited] = min(dp[nowloc][visited], map[nowloc][i] + circuit2(i, visited | 1<<i));
    }
    return dp[nowloc][visited];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i = 0 ; i < n; i++) {
        fullvisit = fullvisit | 1<<i;

        for(int j = 0; j < n; j++) cin >> map[i][j];
    }
    cout << circuit2(0, 1);
}

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

*/