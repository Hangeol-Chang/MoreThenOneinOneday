#include<iostream>
#include<string>

using namespace std;
int main21734() {
	
	string ch;
	cin >> ch;

	int l = ch.length();

	for (int i = 0; i < l; i++) {
		int asc = static_cast<int>(ch[i]);
		int ascsum = 0;

		while (true) {
			ascsum += asc % 10;
			asc = asc / 10;
			if (asc == 0) break;
		}

		for (int j = 0; j < ascsum; j++) cout << ch[i];

		cout << '\n';
	}
	return 0;
}