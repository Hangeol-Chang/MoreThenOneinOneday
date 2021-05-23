#include<iostream>
#include<vector>

using namespace std;

int totaltime;

vector<int> tim;
vector<vector<int>> rel;

void timecount(int dir) {
	totaltime += tim[dir];
	if (dir == 1) {
		cout << totaltime;
		return;
	}
	else {
		int tmp = 0;
		int tmp2 = 0;
		for (int i = 1; i < dir; i++) {
			if (rel[i][dir] == 1 && tim[i] > tmp) {
				tmp = tim[i];
				tmp2 = i;
			}
		}
		timecount(tmp2);
	}
}

int main() {

	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		int N, K, x, y, W;

		cin >> N >> K;
		int tmp;

		tim.assign(N + 1, 0);
		rel.assign(N + 1, vector<int>(N + 1, 0));


		for (int j = 0; j < N; j++) {
			cin >> tim[j + 1];
		}

		for (int j = 0; j < K; j++) {
			cin >> x >> y;
			rel[x][y] = 1;
		}
		cin >> W;

		totaltime = 0;
		timecount(W);
	}
}