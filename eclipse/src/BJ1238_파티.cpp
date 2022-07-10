#include <iostream>
#include <vector>
#include <queue>

// X에서 내려오는 것은 한번에 계산하도록 하면 시간 더 줄듯.

using namespace std;

// n명의 학생, m개의 길
// 모든 위치에서 x로 다익스트라.
class vertex {
    public : 
        int v, w;
        vertex(int vin, int win) {
            v = vin;
            w = win;
        }
};

vector<vertex> *map;

struct cmpvertex {
    bool operator()(vertex v1, vertex v2) {
        return v1.w > v2.w;
    }
};

int dijkstra(int st, int target) {
    bool visited[1001] = {false};
    int dist = 0;

    priority_queue<vertex, vector<vertex>, cmpvertex> que;
    for(vertex ver : map[st]) {
        // std::cout << ver.v << endl;
        que.push(ver);
    }
    visited[st] = true;
    
    while(!que.empty()) {
        vertex now = que.top();
        // cout << "q " << now.v << " " << now.w << endl;
        que.pop();
        visited[now.v] = true;

        if(now.v == target) {
            // cout << st << " " << now.v << " " << " val : " << now.w << endl;
            return now.w;
        }

        // cout << now.v << endl;
        for(vertex ver : map[now.v]) {
            // cout << "candi " << ver.v << endl;
            if(visited[ver.v]) continue;
            
            // cout << "add " << ver.v << " " << ver.w << endl;
            que.push(vertex(ver.v, ver.w + now.w));
        }
    }
}


int main() {
    int N, M, X;
    cin >> N >> M >> X;

    map = new vector<vertex>[N+1];
    for(int i = 0; i < M; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        map[u].push_back(vertex(v, w));
    }
    // 입력 완료.

    int maxd = 0;
    for(int i = 1; i <= N; i++) {
        if(i == X) continue;

        // i부터 X까지 거리 잡기.
        int dist = dijkstra(i, X);
        // X부터 i까지 거리 잡기.
        dist += dijkstra(X, i);
        maxd = max(maxd, dist);
        // cout << "max " << maxd << " " << dist << endl;
    }
    cout << maxd;
}
/*

4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3

*/