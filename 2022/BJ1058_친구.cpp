#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int main() {
    int N;
    cin >> N;
    
    vector<int> *map;
    map = new vector<int>[N+1];

    for(int i = 1; i <= N; i++) {
        string inp; cin >> inp;

        for(int j = 0; j < N; j++)
            if(inp[j] == 'Y')
                map[i].push_back(j+1);
    }
    // 입력 완료.

    // for(int i = 1; i <= N; i++){
    //     for(int f : map[i]) cout << f << " ";
    //     cout << endl;
    // }

    int friends[N+1];
    fill_n(friends, N+1, 0);

    int maxf = 0;
    // 모든 자리의 친구수 확인 절차.
    for(int i = 1; i <= N; i++) {
        queue<int> que;
        // 방문처리 배열
        bool visited[N+1] = {false};
        // 시작위치 방문처리.
        visited[i] = true;

        int count = map[i].size();
        // 1차 친구 추가 
        for(int f : map[i]) {
            que.push(f);
            visited[f] = true;
        }
        // 2차 친구 추가.

        // cout << "i : " << i << endl;
        while(!que.empty()) {
            int now = que.front();
            que.pop();

            // cout << "now " << now << " : ";
            for(int f : map[now]) {
                // cout << f << " ";
                if(!visited[f]){
                    count++;
                    visited[f] = true;
                    // cout << "pass ";
                }
            }
            // cout << endl;
        }
        // cout << endl;
        maxf = max(maxf, count);
    }
    cout << maxf;
}
/*

5
NYYYY
YNYYY
YYNYY
YYYNY
YYYYN


*/