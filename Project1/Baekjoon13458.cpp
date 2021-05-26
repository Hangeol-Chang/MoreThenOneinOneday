#include<iostream>
#include<vector>
#include<cmath>

using namespace std;
int main() {
	int N;
	cin >> N;
	
	vector<int> a;
	a.assign(N, 0);
	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}

	int B, C;
	cin >> B >> C;
	
	for (int i = 0; i < N; i++) {
		if (a[i] <= B) a[i] = 1;
		else a[i] = ceil((float)(a[i] - B) / C) + 1;
	}

	long long sum = 0;
	for (int i = 0; i < N; i++) {
		sum += a[i];
	}
	cout << sum;
}