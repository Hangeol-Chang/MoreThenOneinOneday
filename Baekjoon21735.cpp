#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

vector<int> snow = {0};
int N, M;
int Max = 0;

void dp(int left, int sizenow, int index) {

	left -= 1;
	sizenow += snow[index];

	if (left == 0 or index >= N) {
		//cout << left << index << ' ' << sizenow << '\n';
		if (Max < sizenow) Max = sizenow;
		return;
	}


	dp(left, sizenow, index + 1);
	dp(left, sizenow / 2, index + 2);
}

int main21735() {

	int a;

	cin >> N >> M;
	for (int i = 0; i < N; i++) {

		cin >> a;
		snow.push_back(a);

	}

	dp(M + 1, 1, 0);

	cout << Max;
	return 0;
}