#include<iostream>
#include<vector>

using namespace std;

int main() {
	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		int N, W;
		cin >> N >> W;

		int count;

		vector<vector<int>> enemy;
		vector<vector<int>> set;

		enemy.assign(2, vector<int>(N + 2, 0));
		set.assign(2, vector<int>(N + 2, 1));

		for (int t = 0; t < 2; t++) {
			for (int j = 0; j < N; j++) {
				cin >> enemy[t][j + 1];
			}
			enemy[t][0] = enemy[t][N];
			enemy[t][N + 1] = enemy[t][1];
		}

		for (int j = 1; j <= N; j++) {
			if (set[i] == 0) continue;
			
			
		}
		for (int j = N + 1; j <= 2 * N; j++) {

		}
	}

	return 0;
}