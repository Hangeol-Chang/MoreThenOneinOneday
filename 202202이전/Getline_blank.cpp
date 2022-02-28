#include<iostream>
#include<string>


using namespace std;
int Getline() {

	string str;

	getline(cin, str);

	cout << str << '\n';

	char aa[100];
	cin.getline(aa, 100);

	cout << '\n' << aa << '\n';
	cout << aa[0];


	int N;		
	int a[100];

	cin >> N;
	for (int i = 0; i < N; i++) {

		cin >> a[i];

	}

	return 0;
}