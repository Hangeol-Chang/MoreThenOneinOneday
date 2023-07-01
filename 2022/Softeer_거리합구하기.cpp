#include<iostream>
#include<queue>
#include<vector>

using namespace std;

struct vertex { 
	int v;
	long long w;
	vertex(int vin, long long win) : v(vin), w(win) {}
};

struct cmp {
	bool operator()(vertex v1, vertex v2) {
		return v2.w - v1.w;
	}
};

int main(int argc, char** argv)
{
	// 노드의 수
	int N;
	cin >> N;

	// 간선 배열 입력받기.
	vector<vertex> map[N+1];
	for(int i = 1; i < N; i++) {
		int u, v;
		long long w;
		cin >> u >> v >> w;
		map[u].push_back(vertex(v, w));
		map[v].push_back(vertex(u, w));
	}
	// 맵 완성.

	// 정답을 넣을 배열 선언.
	long long ans[N+1];

	//1부터 N까지의 모든 위치에 대해 다익스트라 실행.
	for(int i = 1; i <= N; i++) {
		priority_queue<vertex, vector<vertex>, cmp> que; 

		long long visited[N+1] = {0};
		// i에서 출발할 수 있는 모든 경우를 집어넣음.
		// cout << "start : " << i << endl;
		for(vertex vr : map[i]) {
			// cout << "add " << vr.v << " " << vr.w << endl;
			que.push(vr);
		}
		visited[i] = -1;
		int visitcount = 1;

		// 모든 지점을 방문할 때 까지 간선을 선택.
		while(visitcount < N) {
			// que에서 제일 짧은 간선 꺼내기.
			vertex now = que.top();
			que.pop();

			// 방문한 적이 있으면 다음으로.
			if(visited[now.v] != 0) continue;
			// 방문처리
			visitcount++;
			visited[now.v] = now.w;

			// 이 지점에서 갈 수 있는 곳들에 대해 que에 추가.
			for(vertex vr : map[now.v])
				if(visited[vr.v] == 0)
					que.push(vertex(vr.v, vr.w + now.w));
		}
		
		// 자기 자신까지 거리를 -1로 초기화 할 것이기 떄문에, 후에 연산을 위해 -1로 초기화
		ans[i] = 1;
		for(long long num : visited) ans[i] += num;
	}

	for(int i = 1; i <= N; i++) cout << ans[i] << endl;

	return 0;
}