#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> dr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

int main() {
    int R, C;
    cin >> R >> C;
    R -= 1;
    C -= 1;
    
    int br, bc;
    cin >> br >> bc;

    vector<vector<int>> board(vector<vector<int>>(br, vector<int>(bc, 0)));

    for(int r = 0; r < br; r++)
        for(int c = 0; c < bc; c++) 
            cin >> board[r][c];

    vector<vector<int>> diffmap(vector<vector<int>>(br, vector<int>(bc, -1)));
    diffmap[R][C] = 0;

    queue<pair<int, int>> visit;
    
    visit.push(pair<int, int>(R, C));
    int maxdiff = 0;    
    while(!visit.empty()) {
        pair<int, int> now = visit.front();
        visit.pop();
\
        for(vector<vector<int>>::iterator it = dr.begin(); it != dr.end(); it++) {
            int nr = now.first + (*it)[0];
            int nc = now.second + (*it)[1];

            if(nr < 0 || nr >= br || nc < 0 || nc >= bc || diffmap[nr][nc] == 0)
                continue;
            
            int num = 0;
            if(board[now.first][now.second] != board[nr][nc]) 
                num = diffmap[now.first][now.second] + 1;
            else
                num = diffmap[now.first][now.second];

            if(diffmap[nr][nc] == -1) {
                diffmap[nr][nc] = num;
                maxdiff = maxdiff > num ? maxdiff : num;

                visit.push(pair<int, int>(nr, nc));
            }
            else {
                if(diffmap[nr][nc] <= num) continue;

                diffmap[nr][nc] = num;
                maxdiff = maxdiff > num ? maxdiff : num;

                visit.push(pair<int, int>(nr, nc));
            }
        }
    }

    vector<int> diffC(maxdiff + 1, 0);
    for(vector<vector<int>>::iterator it = diffmap.begin(); it != diffmap.end(); it++)
        for(vector<int>::iterator it2 = it->begin(); it2 != it->end(); it2++) 
            diffC[*it2] += 1;

    int maxfrequency = 0;
    int targetDiff = 0;

    for(int d = 0; d <= maxdiff; d++) {
        if(diffC[d] >= maxfrequency) {
            maxfrequency = diffC[d];
            targetDiff = d;
        }
    }
    cout << targetDiff << endl;

    vector<pair<int, int>> ans;
    for(int r = 0; r < br; r++)
        for(int c = 0; c < bc; c++) {
            if(diffmap[r][c] == targetDiff) {
                ans.push_back(pair<int, int>(r + 1, c + 1));
            }
        }

    for(vector<pair<int,int>>::iterator it = ans.begin(); it != ans.end(); it++) {
        cout << "[" << it->first << ", " << it->second << "]\n";
    }
}


/*
입력 귀찮아.

3 2
4 6
5 4 3 4 4 4
1 3 2 3 3 5
2 3 4 5 5 1
2 2 3 4 4 3

3 3
5 5
7 9 7 9 7
9 7 9 7 9
7 9 7 9 7
9 7 9 7 9
7 9 7 9 7

*/