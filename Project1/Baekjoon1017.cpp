#include<iostream>
#include<cstring>
#include<vector>
#include<algorithm>

using namespace std;

vector<int> connect[25];
int num1[25], num2[25];
bool visit[25];

bool dfs(int a) {
	if (visit[a]) return false;
	visit[a] = true;

	for (int b : connect[a]) {
		if (num2[b] == -1 || dfs(num2[b])) {
			num1[a] = b;
			num2[b] = a;
			return true;
		}
	}
	return false;
}

int main() {
	int N;
	cin >> N;
	vector<int> n1, n2;

	int tmpval;
	bool firstodd = false;

	for (int i = 0; i < N; i++) {
		cin >> tmpval;

		(tmpval % 2 ? n1 : n2).push_back(tmpval);
		if (i == 0 && tmpval % 2) firstodd = true;
	}
	if (n1.size() != n2.size()) {
		cout << -1;
		return 0;
	}
	if (!firstodd) swap(n1, n2);

	bool era[1000];
	memset(era, 1, sizeof(era));
	for (int i = 3; i < 2000; i += 2) {
		if (!era[i / 2]) continue;
		for (int j = i * i; j < 2000; j += i * 2) era[j / 2] = false;
	}

	for (int i = 0; i < n1.size(); i++) {
		for (int j = 0; j < n1.size(); j++) {
			if (era[(n1[i] + n2[j]) / 2]) connect[i].push_back(j);
		}
	}

	vector<int> ans;
	for (int i : connect[0]) {
		memset(num1, -1, sizeof(num1));
		memset(num2, -1, sizeof(num2));

		int flow = 1;
		num1[0] = i;
		num2[i] = 0;

		for (int j = 1; j < n1.size(); j++) {
			memset(visit, 0, sizeof(visit));

			visit[0] = true;
			if (dfs(j)) flow++;
		}

		if (flow == n1.size()) ans.push_back(n2[i]);
	}
	if (ans.empty()) cout << -1;
	else {
		sort(ans.begin(), ans.end());
		for (int i : ans) cout << i << ' ';
	}
}