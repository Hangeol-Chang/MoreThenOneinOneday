#include<iostream>
#include<queue>

using namespace std;

struct car {
	int i, time;
	car(int iin, int tin) : i(iin), time(tin) {};	
};

int main(int argc, char** argv)
{
	int N;
	cin >> N;

	// A, B, C, D 별로 큐에 넣음.
	// t가 정렬된 채로 들어오기 때문에 가능.
	queue<car> cars[4];
	for(int i = 1; i <= N; i++) {
		int t; char s;
		cin >> t >> s;
	
		cars[s - 'A'].push(car(i, t));
	}
	// 입력 완료.

	// 정답 배열
	int crossTime[N+1];
	fill_n(crossTime, N+1, -1);

	// for(int i = 1; i <= N; i++) cout << " " << crossTime[i];
	// 차가 하나라도 움직일 수 있으면 반복.
	int carcount = N;
	int time = 0;
	int stuck = 0;
	do {
		stuck = 0;
		// 각 위치의 차가 이번에 나갈 수 있는지 판단.
		bool set[4] = {0};
		for(int d = 0; d < 4; d++) {
			// 현재 내 위치에 차가 없으면 다음꺼.
			if(cars[d].empty() || cars[d].front().time > time) continue;

			// 오른쪽 차선 인덱스.
			int idx = (d+3)%4;
			// 오른쪽 차선에 차가 없으면 차 set 하기
			if(cars[idx].empty() || cars[idx].front().time > time) {
				set[d] = true;
			}
			// 여기에 도달하면, 나는 교착된 것.
			else stuck++;
		}
		
		// 나갈 수 있는 차 내보내기.
		for(int d = 0; d < 4; d++) {
			if(!set[d]) continue;

			car out = cars[d].front();
			cars[d].pop();
			carcount--;
			crossTime[out.i] = time;
		}
		time++;

	} while(carcount > 0 && stuck < 4);

	for(int i = 1; i <= N; i++) cout << crossTime[i] << endl;
	return 0;
}