#include<iostream>

using namespace std;

int ar[10001];

int tag(int a) {
	int sum = a;

	while (true) {
		sum += a % 10;
		a = a / 10;
		if (a == 0) break;
	}

	return sum;
}

int index;
int main4673() {
	for (int i = 1; i < 10001; i++) {
		index = tag(i);

		ar[index] = 1;
	}

	for (int i = 1; i < 10001; i++) {
		if (ar[i] != 1) cout << i << '\n';
	}
	return 0;
}