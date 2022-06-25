#include <iostream>

using namespace std;

int totcost;
int N, M;

int *memories;
int *shutcost;

void sel(int idx, int cost, int memory){
    if(cost >= totcost) return;
    if(memory >= M) {
        totcost = cost;
        return;
    }

    for(int i = idx; i < N; i++)
        sel(i+1, cost + shutcost[i], memory + memories[i]);
    
}

int main() {
    cin >> N >> M;

    // 초기화
    totcost = 1000000;

    memories = new int[N];
    shutcost = new int[N];
    
    for(int i = 0; i < N; i++) cin >> memories[i];
    for(int i = 0; i < N; i++) cin >> shutcost[i];

    int dp[N+1][M+1];

    sel(0, 0, 0);
    cout << totcost; 
}