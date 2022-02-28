#include<iostream>
#include<cmath>

using namespace std;

int main1004() {
	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		int count = 0;
		int x1, y1, x2, y2;

		cin >> x1 >> y1 >> x2 >> y2;

		int n;
		int d1, d2;
		int r2;
		cin >> n;
		for (int j = 0; j < n; j++) {
			int x, y, r;
			cin >> x >> y >> r;

			d1 = pow(x1 - x, 2) + pow(y1 - y, 2);
			d2 = pow(x2 - x, 2) + pow(y2 - y, 2);
			r2 = r * r;

			if (r2 > d1 && r2 > d2) continue;
			else if (r2 > d1 || r2 > d2) count++;
		}
		cout << count << '\n';
	}

	return 0;
}