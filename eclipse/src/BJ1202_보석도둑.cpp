#include <iostream>
#include <queue>
#include <algorithm>


using namespace std;

struct gem {
    int size;
    long long value;
};

bool comparegem(gem a, gem b) {
    return a.size < b.size;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // N개의 보석, K개의 가방
    int N, K;
    cin >> N >> K;

    // N 개의 보석 크기 나열
    gem gems[N];
    for(int i = 0; i < N; i++)
        cin >> gems[i].size >> gems[i].value;

    // K 개의 가방 크기 나열.
    int bags[K];
    for(int i = 0; i < K; i++) 
        cin >> bags[i];
    
    // 입력 끝.

    // 정렬.(all 오름차순)
    sort(gems, gems + N, comparegem);
    sort(bags, bags + K);

    // cout << "debug" << endl;
    // for(int i = 0; i < N; i++) {
    //     cout << gems[i].size << " " << gems[i].value << endl;
    // }
    // cout << endl;
    // for(int i = 0; i < K; i++) {
    //     cout << bags[i] << " ";
    // }
    // cout << endl;

    int gemidx = 0;
    int bagidx = 0;

    // K번째 가방까지 다 넣거나
    long long ans = 0;
    priority_queue<long long> pq;

    while(bagidx < K) {
        while(gemidx < N && gems[gemidx].size <= bags[bagidx]){
            pq.push(gems[gemidx].value);
            gemidx++;
        }
        if(!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
        bagidx++;
    }
    cout << ans << endl;
}

/*

6 5
3 30
3 40
10 1
1 70
2 20
5 30
1
2
6
4
9

190


4 2
4 100
5 110
6 90
7 80
5
7

210

5 7
0 10
0 30
0 70
0 10000
0 41414
1
2
3
4
5
0
0

51524

*/