#include <iostream>

using namespace std;

int main() {
	int T;
	cin >> T;
	
	for (int t = 1; t <= T; t++) {
		string ini;
		
		cin >> ini;
		int size = ini.size();
		
		cout << ini[0] << ini[size - 1] << endl;
	}
}