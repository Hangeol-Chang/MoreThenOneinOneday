#include<iostream>

using std::cout;		using std::cin;

int main() {
	int a;
	cin >> a;

	int tmp = 0;
	int count = 0;
	int save = a;
	
	bool first = true;

	while (a != save || first == true) {
		if (first == true) first = false;

		tmp = a / 10 + a % 10;
		a = (a % 10) * 10 + tmp % 10;
		count++;
	}
	cout << count;

	return 0;
}