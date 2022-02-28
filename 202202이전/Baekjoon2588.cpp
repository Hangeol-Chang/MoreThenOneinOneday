#include<iostream>
#include<cmath>

using std::cout;	using std::cin;	using std::endl;

int main2588() {
	int a, b;
	cin >> a;
	cin >> b;

	int t[3];
	
	for (int i = 0; i < 3; i++) {
		t[i] = ( b / (int)pow(10,i) ) % 10 * a;
		cout << t[i] << endl;
	}
	cout << a * b;

	return 0;
}