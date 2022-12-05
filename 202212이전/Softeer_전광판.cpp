#include<iostream>
#include<cmath>
/*

  0
1   2
  3
4   5
  6
위에처럼 7세그먼트를 매핑함.
*/

// 0 1 2 3 4 5 6 7 8 9 empty를 표현하는 세그먼트
bool code[11][7] = {
	{1,1,1,0,1,1,1},	// 0
	{0,0,1,0,0,1,0}, 	// 1
	{1,0,1,1,1,0,1},	// 2
	{1,0,1,1,0,1,1},	// 3
	{0,1,1,1,0,1,0},	// 4
	{1,1,0,1,0,1,1},	// 5
	{1,1,0,1,1,1,1},	// 6
	{1,1,1,0,0,1,0},	// 7
	{1,1,1,1,1,1,1},	// 8
	{1,1,1,1,0,1,1},	// 9
	{0,0,0,0,0,0,0}		// empty
};

using namespace std;

int getlen(int num) {
	int len = 0;
	while(num > 0) {
		num /= 10;
		len++;
	}
	return len;
}

int main(int argc, char** argv)
{
	int T;
	cin >> T;
	for(int t = 1; t <= T; t++) {
		int a, b;
		cin >> a >> b;

		int alen = getlen(a);
		int blen = getlen(b);

		int click = 0;
		for(int i = 5; i >= 1; i--) {
			int nomi = pow(10, i-1);

			int idfa = 10;
			int idfb = 10;
			
			// 수에 이번 자리가 존재하면.
			if(alen >= i) idfa = (a/nomi) % 10;
			if(blen >= i) idfb = (b/nomi) % 10;

			for(int s = 0; s < 7; s++) {
				if(code[idfa][s] != code[idfb][s]) click++;
			}
			// cout << idfa << " " << idfb << " " << click << endl;
		}
		cout << click << endl;
	}

	return 0;
}