#include<iostream>
#include<vector>
#include<queue>

// 다익스트라
// 답이 존재하는 경우만 주어짐.
using namespace std;

struct cmp {
    bool operator() (pair<int, int> &a, pair<int, int> &b) {
        // second 기준 오름차순 정렬
        return a.second > b.second;
    }
};

int main() {
    int N, T;
    cin >> N >> T;

    // 연결된 노드와 가중치를 적기.
    vector<vector<pair<int, int>>> grp(N+1);
    
    // 트리 입력받기
    for(int i = 0; i < N-1; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        
        grp[u].push_back(make_pair(v, w));
        grp[v].push_back(make_pair(u, w));
    }

    bool* visited = new bool[N+1];
    
    // 연산 시작
    for(int t = 1; t <= T; t++) {
        int s, e;
        cin >> s >> e;
        priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> que;

        // 시작점에서 갈 수 있는 곳 전부 넣기.
        for(pair<int, int> p : grp[s]) que.push(p);
        fill_n(visited, N+1, 0);
        visited[s] = 1;

        while(!que.empty()) {
            pair<int, int> now = que.top();
            que.pop();
            // cout << now.first << " " << now.second << "\n";

            if(now.first == e) {
                cout << now.second << "\n";
                break;
            }

            for(pair<int, int> p : grp[now.first]) {
                // cout << "ddd : " << p.first << " " << p.second << "\n";
                if (visited[p.first]) continue;

                visited[now.first] = 1;
                que.push(make_pair(p.first, p.second + now.second));
            }
        }
    }
}

/*

4 2
2 1 2
4 3 2
1 4 3
1 2
3 2

*/
