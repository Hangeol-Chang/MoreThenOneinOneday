#include <iostream>
#include <limits>

#define INF numeric_limits<int>::max()

using namespace std;

struct matrix {
    int r;
    int c;
    int sum = 0;
};

int main() {
    int n;
    cin >> n;

    matrix map[n][n];
    for(int i = 0; i < n; i++)
        cin >> map[i][i].r >> map[i][i].c;
    // 입력 완료.

    for(int c = 0; c < n; c++) {
        for(int r = c-1; r >= 0; r--) {
            //map[r][c] 위치를 만들어야 함.
            
            for(int d = r; d < c; d++) {
                // map[r][d] 에서 r 가져옴;
                // map[r+d][c] 에서 c 가져옴;
                int tmpsum = map[r][d].sum + map[d+1][c].sum + (map[r][d].r * map[r][d].c * map[d+1][c].c);

                // cout << r << " " << c << " " << d << " sum : " << map[r][c].sum << " " << tmpsum << endl;
                if(map[r][c].sum == 0) {
                    map[r][c].sum = tmpsum;
                    map[r][c].r = map[r][r].r;
                    map[r][c].c = map[c][c].c;
                }
                else if(tmpsum < map[r][c].sum) {
                    map[r][c].sum = tmpsum;
                    map[r][c].r = map[r][d].r;
                    map[r][c].c = map[d+1][c].c;
                }
            }
        }
    }
    cout << map[0][n-1].sum;
}

/*

4
5 3
3 2
2 6
6 4

5
1 10
10 1
1 10
10 1
1 10


*/