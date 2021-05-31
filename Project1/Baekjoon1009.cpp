#include<iostream>
#include<cmath>
#include<vector>

using namespace std;
int main1009() {
	int T;
	cin >> T; 
	
	for (int i = 0; i < T; i++) {
		int a, b;
		cin >> a >> b;

		vector<int> t = { (int)pow(a, 4) % 10 };

		int tmp;
		int j = 1;
		while (true){
			tmp = (int)pow(a, j) % 10;
			//cout << tmp << ' ';

			if (tmp == t[0]) break;
			else {
				t.push_back(tmp);
				j++;
			}
		}
		//cout << "///";

		int re;
		re = b % t.size();

		cout << (t[re] != 0 ? t[re] : 10)  << endl;
		
	}
	return 0;
}
