#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> map(N+1, 0);
    vector<int> visited(N+1, -1);
    for(int i = 1; i <= N; i++) cin >> map[i];

    queue<int> candis;
    int st, ed;
    cin >> st >> ed;

    visited[st] = 0;
    candis.push(st);

    if(st == ed) {
        cout << 0;
        return 0;
    }

    while(!candis.empty()) {
        int now = candis.front();
        candis.pop();
        int jump = map[now];
        int move = visited[now] + 1;

        // cout << "now : " << now << " " << jump << " " << move << endl;

        // 위쪽 탐색.
        int nextnum = now + jump;
        while(nextnum <= N) {
            // 방문한 적이 없으면
            if(visited[nextnum] == -1 || visited[nextnum] > move) {
                visited[nextnum] = move;
                candis.push(nextnum);
            }

            if(nextnum == ed) goto endPoint;
            nextnum += jump;
        }

        // 아래쪽 탐색.
        nextnum = now - jump;
        while(nextnum > 0) {
            if(visited[nextnum] == -1 || visited[nextnum] > move) {
                visited[nextnum] = move;
                candis.push(nextnum);
            }
            nextnum -= jump;
        }

        // 한 싸이클 돌때마다 뽑아보기
        // for(vector<int>::iterator it = visited.begin(); it != visited.end(); it++) {
        //     cout << *it << " ";            
        // }
        // cout << endl;
    }
    endPoint:;

    // for(vector<int>::iterator it = visited.begin(); it != visited.end(); it++) {
    //     cout << *it << " ";            
    // }
    // cout << endl;
    cout << visited[ed];    
}