#include<iostream>
#include<queue>

/*
시뮬레이션

빈 칸   .
소나기   *
강      X
집      H
출발위치 W

소나기는 매 분 인접한 네 개 칸으로 확산.

집에 도착할 수 없다면 FAIL 출력

*/
using namespace std;

int R, C;
char **map;

int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

struct loc {
	int r, c;
	loc(int rin, int cin) : r(rin), c(cin) {};
	loc() {};
};

int main(int argc, char** argv)
{
	cin >> R >> C;
	loc stt;

	// 소나기 위치 저장할 배열.
	queue<loc> rain;
	// 내 현재위치 저장할 배열
	queue<loc> que;

	// 맵을 만들고, 강으로 초기화.
	map = new char *[R+2];
	for(int i = 0; i <= R+1; i++) {
		map[i] = new char[C+2];
		fill_n(map[i], C+2, 'X');
	}

	// 맵 입력받기.
	for(int i = 1; i <= R; i++) {
		string line;
		cin >> line;
		for(int j = 1; j <= C; j++) {
			map[i][j] = line[j-1];
			// 소나기와 출발위치에 대해 처리.
			if(map[i][j] == '*') 	  rain.push(loc(i, j));
			else if(map[i][j] == 'W') que.push(loc(i, j));
		}
	}
	// 입력 완료.

	// 이동할 것이 남으면 계속 이동하기
	int time = 0;
	while(!que.empty()) {
		time++;
		
		// 1. 태범이의 이동.
		int thistime = que.size();
		for(int i = 0; i < thistime; i++) {
			loc now = que.front();
			que.pop();
			if(map[now.r][now.c] == '*') continue;

			for(int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if(map[nr][nc] == '.') {
					// 방문처리
					map[nr][nc] = '!';
					que.push(loc(nr, nc));
				}
				else if(map[nr][nc] == 'H') {
					cout << time;
					return 0;
				}
			}
		}
		
		// 2. 소나기의 확산.
		int rainamount = rain.size();
		for(int i = 0; i < rainamount; i++) {
			loc now = rain.front();
			rain.pop();

			for(int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if(map[nr][nc] == '.' || map[nr][nc] == '!') {
					// 비 퍼트리고, 다음 확산을 위해 저장.
					map[nr][nc] = '*';
					rain.push(loc(nr, nc));
				}
			}
		}
	}
	cout << "FAIL";
	return 0;
}

/*
3 3
H*.
*..
..W

1 3
HW*

5 5
.H...
..*..
.*W*.
..*..
.....

5 5
H****
*****
*****
****W

5 5
H....
****.
****.
****W

2 3
H.W
.*.

*/