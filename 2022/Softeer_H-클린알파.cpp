#include<iostream>

/*
매 초 바이러스가 침입.
매 초 p배가 됨.

N초 후에는 몇마리?

3 3
1 2 3

1 : 1
2 : 1*3 + 2
3 : (1*3 + 2)*3 + 3
	> 1*3^2 + 2^3 + 3

k초에 들어온 것은 P^(N-k)배가 됨.
지금 있는거에 P배를 하고 바이러스 더하기.
1000000007 로 나눈 나머지.

분할정복

*/

using namespace std;

long long *multimap;

int main(int argc, char** argv)
{
	long long P;
	int N;
	cin >> P >> N;

	multimap = new long long[N+1];
	multimap[0] = 1;
	for(int i = 1; i <= N; i++) {
		multimap[i] = (multimap[i-1]*P) % 1000000007;
		// cout << multimap[i] << endl;
	}


	long long ans = 0;
	for(int k = 1; k <= N; k++) {
		int virus;
		cin >> virus;

		ans = (ans + (virus * multimap[N-k])) % 1000000007;
	}
	cout << ans;
	return 0;
}