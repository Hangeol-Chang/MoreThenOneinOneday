#include<iostream>
#include<cmath>

using std::cout;	using std::cin;
int main1002() {
	int x1, y1, r1, x2, y2, r2, r_m,r_M, d;
	int N;
	cin >> N;
	
	for (int i = 0; i < N; i++) {

		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

		d = pow(x1 - x2, 2) + pow(y1 - y2, 2);
		r_M = pow(r1 + r2, 2);
		r_m = pow(r1 - r2, 2);

		if (d == 0) {
			if (r_m == 0) cout << -1 << '\n';
			else cout << 0 << '\n';
		}
		else if (d == r_M || d == r_m) cout << 1 << '\n';
		else if (d > r_m && d < r_M) cout << 2 << '\n';
		else cout << 0 << '\n';
	}
	return 0;
}