#include<iostream>
#include<vector>

using namespace std;
int main() {
	int N;
	cin >> N;
	
	vector<int> a;
	a.assign(N + 1, 0);
	
	for (int i = 1; i <= N; i++) {
		cin >> a[i];
	}
}