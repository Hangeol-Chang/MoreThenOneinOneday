#include <iostream>
#include <limits>

using namespace std;

int n;
int **map;
int *dp;
int fullvisit;

int circuit2(int nowloc, int visited) {
    if(dp[visited] != 0) return dp[visited];

    //저장되지 않았으면, dp[visited]를 구해야 함.
    int mincost = numeric_limits<int>::max();
    for(int i = 1; i <= n; i++) {
        if(map[nowloc][i] != 0 && (~visited & 1<<i) > 0) {
            mincost = min(mincost, map[nowloc][i] + circuit2(i, visited | 1<<i));
        } 
    }
}

/*
void circuit(int nowloc, int visited, int cost) {
    if(cost >= mincost) return;
    if(nowloc == 0) {
        if (visited != 0) {
            if(visited == fullvisit) {
                mincost = min(cost, mincost);
            }
            return;
        }
    }

    for(int i = 0; i < n; i++) {
        // 길이 있고, 방문한 적이 없으면
        if(map[nowloc][i] != 0 && (~visited & 1<<i) > 0) {
            circuit(i, visited | 1<<i, cost + map[nowloc][i]);
        }
    }

}
*/

int main() {
    cin >> n;

    map = new int *[n];
    for(int i = 0 ; i <= n; i++) {
        fullvisit = fullvisit | 1<<i;
        map[i] = new int[n];
        for(int j = 1; j <= n; j++) 
            cin >> map[i][j];
    }
    dp = new int[fullvisit+1];
    // 입력 완료.
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            if(map[i][j] != 0) {
                int bit = 1<<
                dp[fullvisit]
            }
        }
    }

    // 현재 0번 위치에 있으며, 0번만 방문하였음.
    cout << circuit2(0, 0, 0);
}