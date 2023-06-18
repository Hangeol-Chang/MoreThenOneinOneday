#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int ans = -1;
// 0이면 안짤린거, 1이면 짤린거.
vector<int> cuted;

int N;

struct tree {
    int x;
    int y;
    int height;
    
    tree(int xin, int yin, int zin) : x(xin), y(yin), height(zin) {}; 
};
bool treeComparer(tree a, tree b) {
    return a.height < b.height;
}
vector<tree> map;

void judgeAns(int cutNum) {
    /*
        여기 들어와야되는 로직이?

        map과 cuted를 가지고,
            1. 자른 나무 길이 계산
            2. 테두리 계산. > 최저x, y / 최고x, y
            3. 자른 나무 길이가 테두리를 덮을 수 있는지 확인.
            
            *. 백트래킹에 대한 신뢰도?
    */

    int minX = 1000001, minY = 1000001, maxX = 0, maxY = 0;
    int timber = 0;
    for(int i = 0; i < N; i++) {
        // 자른 나무면
        if(cuted[i] == 1) {
            timber += map[i].height;
        }
        else {
            minX = min(map[i].x, minX);
            minY = min(map[i].y, minY);
            
            maxX = max(map[i].x, maxX);
            maxY = max(map[i].y, maxY);
        }
    }
    
    int timberNeeded = 2 * ( (maxX - minX) + (maxY - minY) );
    if(timberNeeded <= timber) {
        ans = cutNum;
    }
    // for(vector<int>::iterator it = cuted.begin(); it != cuted.end(); it++) {
    //     cout << *it << " ";
    // }
    // cout << endl;
}

// st - 시작위치
// cutNum - 현재 자른 수
// cutTargetNum - 자를 나무 수
void run(int st, int cutNum, int cutTargetNum) {
    if(cutNum == cutTargetNum) {
        judgeAns(cutNum);
        return;
    }

    for (int i = st; i < N; i++) {
        if(ans > 0) return;
        // i번쩨 나무를 자름.
        cuted[i] = 1;
        run(i + 1, cutNum + 1, cutTargetNum);
        cuted[i] = 0;
    }
}

int main() {
    cin >> N;
    cuted.resize(N);
    fill_n(cuted.begin(), N, 0);

    // 입력구
    for(int i = 0; i < N; i++) {
        int x, y, z;
        cin >> x >> y >> z;
        map.push_back(tree(x, y, z));
    }

    // 높이가 높은 순서로 정렬함.
    sort(map.rbegin(), map.rend(), treeComparer);

    // input/sort 검증 완료
    // for(vector<tree>::iterator it = map.begin(); it != map.end(); it++) {
    //     cout << it->height << " ";
    // }


    // c == N 인 경우는 존재할 수 없음
    for(int c = 1; c <= N; c++) {
        run(0, 0, c);
        // cout << endl;
    }
    cout << ans;
}