#include<iostream>
#include<map>
#include<queue>
#include<vector>

/*
N개의 회의실
회의실 예약 시스템
9 ~ 18 시 까지 이용 가능. 시간 단위로 시작, 종료 설정.
하나의 회의를 ( 회의실, 시작 시간, 끝 시간 )으로 나타냄.

회의는 겹칠 수 없음. 종료하는 시간에, 회의를 시작하는 것은 가능.
회의 시간이 0인 회의는 없음.

이미 예약된 M개의 회의에 대해
회의실별로 비어있는 시간대를 정리해 출력해보자.

9 10 11 12 13 14 15 16 17 18 (-9해서 사용)
9 ~ 12 면 9, 10, 11만 채우기.

*/
using namespace std;

struct conference {
	int st, ed;	
	conference(int stin, int edin) : st(stin), ed(edin) {}
};

int main(int argc, char** argv)
{
	// 회의실 수 N, 회의 수 M
	int N, M;
	cin >> N; cin >> M;

	map<string, int> rooms;
	bool **conferences;
	conferences = new bool *[N];	// 회의가 없으면 false

	priority_queue<string> tmprooms;

	// 회의실 인덱스 배정
	for(int i = 0; i < N; i++) {
		// 회의실 별 시간표 작성.
		conferences[i] = new bool[10];
		string tmp;
		cin >> tmp;
		
		tmprooms.push(tmp);
	}
	// 오름차순으로 정렬된 회의실 꺼내어 정리.
	for(int i = 0; i < N; i++) {
		rooms[tmprooms.top()] = i;
		tmprooms.pop();
	}

	// 회의 배치
	for(int i = 0; i < M; i++) {
		string room;
		int st, ed;
		cin >> room >> st >> ed;
		int roomidx = rooms[room];

		for(int t = st-9; t < ed-9; t++)
			conferences[roomidx][t] = true;
	}
	// 입력 완료.

	// for(int i = 0; i < N; i++) {
	// 	for(int j = 0; j < 10; j++) {
	// 		cout << conferences[i][j] << " ";
	// 	}
	// 	cout << endl;
	// }
	// 모든 회의실애 대해 투포인터로 처리
	for(auto iter = rooms.begin(); iter != rooms.end(); iter++ ) {
		string room = iter -> first;
		int roomidx  = iter -> second;
		cout << "Room " << room << ":" << endl;

		int isavail = 0;
		string prt = "";
		int st = 0;
		int ed = 0;
		vector<conference> freetime;
		while(st < 9) {
			// 회의실이 비기 시작하는 시간 잡기.
			while(conferences[roomidx][st] == true) st++;
			if(st >= 9) break;			

			ed = st;
			while(ed < 9 && conferences[roomidx][ed] == false) ed++;
			freetime.push_back(conference(st+9, ed+9));
			isavail++;
			
			st = ed;
		}
		if(!isavail) cout << "Not available\n";
		else {
			cout << isavail << " available:\n";
			for(conference c : freetime) {
				printf("%02d-%02d\n", c.st, c.ed);
			}
		}
		if(roomidx != 0) cout << "-----\n";
	}

	return 0;
}