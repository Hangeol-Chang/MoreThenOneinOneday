#include <iostream>
#include <vector>

using namespace std;

vector<vector<vector<int>>> parts(5, vector<vector<int>>());
vector<vector<int>> ans;

int N;
int maxbit = 31;

bool mapCmpOperator(vector<vector<int>> a, vector<vector<int>> b) {
    int R = a.size();
    int C = a[0].size();

    for(int r = 0; r < R; r++) {
        for(int c = 0; c < C; c++) {
            if(a[r][c] == b[r][c]) continue;
            if(a[r][c] <  b[r][c]) return true;
            if(a[r][c] >  b[r][c]) return false;
        }
    }
    return true;
}

void run(int used, vector<vector<int>> map) {
    // cout << used << endl;
    // 여기 도착하면 완성된거임. 5개를 다 써야 겨우 여기 들어옴.
    if(used == maxbit) {
        // maked = true;
        // 최종 출력을 여기서 해야 할 듯.
        
        if(mapCmpOperator(map, ans)) {
            // 유효성검증.
            // for(vector<vector<int>>::iterator it = map.begin(); it != map.end(); it++) {
            //     for(vector<int>::iterator it2 = it->begin(); it2 != it->end(); it2++) {
            //         cout << *it2 << endl;
            //         if(*it2 == 0) return;
            //     }
            // }
            copy(map.begin(), map.end(), ans.begin());
        }
        // cout << "maked\n";
        // // 답이 나오면 끝내는게 아니라, 사전순으로 비교를 쳐야함. 시발
        // for(vector<vector<int>>::iterator it = map.begin(); it != map.end(); it++) {
        //     for(vector<int>::iterator it2 = it->begin(); it2 != it->end(); it2++) {
        //         cout << *it2 << " ";
        //     }
        //     cout << "\n";
        // }    
        // cout <<"\n";
        return;
    }

    // 디버깅
    // for(vector<vector<int>>::iterator it = map.begin(); it != map.end(); it++) {
    //     for(vector<int>::iterator it2 = it->begin(); it2 != it->end(); it2++) {
    //         cout << *it2 << " ";
    //     }
    //     cout << "\n";
    // }
    // cout << "\n";
    

    for(int i = 0; i < 5; i++) {
        // 이미 사용된거면 안씀.
        if(used & 1<<i) continue;
        
        // 넣을 위치 찾기.
        int partR = parts[i].size(), partC = parts[i][0].size();
        int nr = -1, nc = -1;

        vector<vector<int>> newmap;
        newmap.assign(map.size(), vector<int>(map.size()));
        copy(map.begin(), map.end(), newmap.begin());

        bool in = false;
        // 모든 가능한 위치에 넣어보기.
        for(int R = 0; R < N - partR + 1; R++) {
            for(int C = 0; C < N - partC + 1; C++) {

                for(int r = 0; r < partR; r++) {
                    for(int c = 0; c < partC; c++) {
                        // 둘 다 0이 아니면 겹침
                        if(newmap[R + r][C + c] != 0 && parts[i][r][c] != 0) goto nextCalc;
                        newmap[R + r][C + c] += parts[i][r][c];
                    }
                }

                // 위에 식을 통과하면, 다음 계산 해보기.
                // 사전순으로 앞서면.
                if(mapCmpOperator(newmap, ans)) {
                    run(used | 1<<i, newmap);
                    goto nextCalc2;
                }

                nextCalc:;
            }
        }
        nextCalc2:;
    }
}

int main() {
    cin >> N;
    ans = vector<vector<int>>(N, vector<int>(N, 6));
    int valid = 0;

    for(int i = 0; i < 5; i++) {
        int R, C; cin >> R >> C;
        parts[i] = vector<vector<int>>(R, vector<int>(C, 0));

        for(int r = 0; r < R; r++) {
            string inp; cin >> inp;
            for (int c = 0; c < C; c++) {
                if(inp.at(c) == '#') {
                    parts[i][r][c] = i+1;
                    valid++;
                }
                else                 parts[i][r][c] = 0;
            }
        }
    }
    if(valid != N*N) {
        cout << "gg";
        return 0;
    }

    // for(vector<vector<vector<int>>>::iterator it1 = parts.begin(); it1 != parts.end(); it1++) {
    //     for(vector<vector<int>>::iterator it2 = it1->begin(); it2 != it1->end(); it2++) {
    //         for(vector<int>::iterator it3 = it2->begin(); it3 != it2->end(); it3++) {
    //             cout << *it3 << " ";
    //         }
    //         cout << "\n";
    //     }
    //     cout << "\n";
    // }

    // N * N 사이즈의 맵을 넘겨줌.
    run(0, vector<vector<int>>(N, vector<int>(N, 0)));
    if(ans[0][0] == 6) cout << "gg";
    else {
        // cout << "ans maked\n";
        for(vector<vector<int>>::iterator it = ans.begin(); it != ans.end(); it++) {
            for(vector<int>::iterator it2 = it->begin(); it2 != it->end(); it2++) {
                cout << *it2;
            }
            cout << "\n";
        }    
    }
}

/*

5
2 5
#....
#####
1 5
#####
1 5
#####
1 5
#####
1 4
####

5
5 5
#####
....#
....#
...##
...##
1 3
###
2 4
####
...#
1 3
###
1 3
###


5
5 5
..#..
..#..
#####
..#..
..#..
2 2
##
##
2 2
##
##
2 2
##
##
2 2
##
##

5
5 2
##
#.
#.
#.
#.
1 5
#####
1 5
#####
1 5
#####
1 4
####

*/