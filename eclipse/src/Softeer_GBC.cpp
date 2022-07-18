#include<iostream>
#include<algorithm>

/*
n개의 구간으로 엘리베이터 구분.
각 구간마다 제한 속도 존재.
구간의 총 합은 100m

구간에서 속도를 벗아난 값을 구해야 함.

*/

using namespace std;

int main(int argc, char** argv)
{
	int N, M;
	cin >> N >> M;

	int map[100];
	
	int now = 0;
	for(int i = 0; i < N; i++) {
		int dist, speed;
		cin >> dist >> speed;

		for(int j = now; j < now + dist; j++) map[j] = speed;
		
		now += dist;
	}
	// 세팅 완료.
	
	// for(int i  =0; i < 100; i++) cout << i << " " << map[i] << endl;
	
	int maxoff = 0;
	now = 0;
	
	for(int i = 0; i < M; i++) {
		int dist, speed;
		cin >> dist >> speed;
		for(int j = now; j < now + dist; j++) {
			map[j] = speed - map[j];
			maxoff = max(map[j], maxoff);
		}
		now += dist;
	}
	cout << maxoff;
	return 0;
}