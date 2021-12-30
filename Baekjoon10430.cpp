#include<iostream>

using std::cout;	using std::cin;	using std::endl;

int main10430() {
	int a, b, c;
	cin >> a >> b >> c;

	cout << (a + b) % c << endl;
	cout << ((a % c) + (b % c)) % c << endl;
	cout << (a * b) % c << endl;
	cout << ((a % c) * (b % c)) % c << endl;

	return 0;
}