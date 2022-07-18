#include<iostream>
#include<queue>

using namespace std;

struct car {
	int i, time;
	car(int iin, int tin) : i(iin), time(tin) {};
	car() {};
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
	int carcount = N;
	int time = 0;
	int stuck = 0;

	struct car set[4];
	bool cango[4];
	// 제일 앞 차들 가져오기.
	for(int d = 0; d < 4; d++) {
		if(cars[d].empty()) set[d] = car(0,1000000001);
		else {
			set[d] = cars[d].front();
			cars[d].pop();
		}
	}

	do {
		fill_n(cango, 4, false);
		stuck = 0;
		// 각 위치의 차가 이번에 나갈 수 있는지 판단.
		for(int d = 0; d < 4; d++) {
			// 교차로에 도착하지 못한 차면 다음꺼 진행.
			if(set[d].time > time) continue;

			// 오른쪽 차선 인덱스
			int idx = (d + 3) % 4;
			// 오른쪽에 차가 없으면 
			if(set[idx].time > time) cango[d] = true;
			else stuck++;
		}

		// 나갈 수 있는 차 내보내기.
		for(int d = 0; d < 4; d++) {
			if(!cango[d]) continue;

			carcount--;
			crossTime[set[d].i] = time;
			
			if(cars[d].empty()) set[d] = car(0, 1000000001);
			else {
				set[d] = cars[d].front();
				cars[d].pop();
			}
		}

		// 새로운 차 들어오기.
		time++;

	} while(carcount > 0 && stuck < 4);

	for(int i = 1; i <= N; i++) cout << crossTime[i] << endl;
	return 0;
}