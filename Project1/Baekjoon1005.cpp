#include<iostream>
#include<vector>

using namespace std;

vector<int> tim;
vector<int> maxtim;
vector<vector<int>> rel;
int N;

int timecount(int dir) {
	int tmp = 0;

	for (int i = 1; i < N + 1; i++) {
		if (rel[i][dir] == 1) {
			if (maxtim[i] == -1) timecount(i);

			if (maxtim[i] > tmp) tmp = maxtim[i];
		}
	}
	maxtim[dir] = tmp + tim[dir];
	return maxtim[dir];
}

int main1005() {

	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		int K, x, y, W;

		cin >> N >> K;
		int tmp;

		tim.assign(N + 1, 0);
		maxtim.assign(N + 1, -1);
		rel.assign(N + 1, vector<int>(N + 1, 0));

		
		for (int j = 0; j < N; j++) {
			cin >> tim[j + 1];
		}

		for (int j = 0; j < K; j++) {
			cin >> x >> y;
			rel[x][y] = 1;
		}
		cin >> W;
		
		timecount(W);
		cout << maxtim[W] << endl;
	}

	return 0;
}