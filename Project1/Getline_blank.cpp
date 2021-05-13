#include<iostream>
#include<string>

using namespace std;

int main() {

	string str;

	getline(cin, str);
	
	cout << str << '\n';

	char aa[100];
	cin.getline(aa, 100);
	
	cout << '\n' << aa << '\n';
	cout << aa[0];


	int N;
	int a[100];
	for (int i = 0; i < N; i++) {

		cin >> a[i];

	}
}