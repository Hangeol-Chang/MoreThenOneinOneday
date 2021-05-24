#include<iostream>
#include<vector>

using namespace std;

int main() {
	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		int N, W;
		cin >> N >> W;

		vector<int> enemy;
		enemy.assign(N * 2 + 1, 0);

		for (int t = 0; t < 2; t++) {
			for (int j = 0; j < N; j++) {
				cin >> enemy[(t * N) + j + 1];
			}
		}

		for(int j = 0; j < 17; j++)	cout << enemy[j] << endl;
	}

	return 0;
}