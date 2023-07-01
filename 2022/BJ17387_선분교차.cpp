#include <iostream>
#include <algorithm>

using namespace std;

struct coordinate {
    long long x;
    long long y;
};

bool comparecoordi(const coordinate p1, const coordinate p2) {
    if(p1.x != p2.x) return p1.x - p2.x;
    else             return p1.y - p2.y;
}

void partcal(long long px1, long long px2, long long px3, long long px4) {
    long long x1 = min(px1, px2);
    long long x2 = max(px1, px2);
    
    long long x3 = min(px3, px4);
    long long x4 = max(px3, px4);

    if(x2 >= x3 && x1 <= x4) cout << 1;
    else cout << 0; 
}


int externalproduct(coordinate std, coordinate p1, coordinate p2) {
    coordinate dir1, dir2;
    dir1.x = p1.x - std.x;
    dir1.y = p1.y - std.y;

    dir2.x = p2.x - std.x;
    dir2.y = p2.y - std.y;

    long long res = dir1.x * dir2.y - dir2.x * dir1.y;

    // long long res2 = std.x * p1.y + p1.x * p2.y + p2.x * std.y;
    // res2 -= std.y * p1.x + p1.y * p2.x + p2.y * std.x;
    // cout << res << " " << res2 << endl;

    if(res > 0) return 1;
    else if(res == 0) return 0;
    else return -1;
}

int main() {
    // 좌표 두 개 받아서 교차 판단.
    coordinate p1, p2, p3, p4;

    cin >> p1.x >> p1.y >> p2.x >> p2.y;
    cin >> p3.x >> p3.y >> p4.x >> p4.y;
    // 입력 끝.

    // p1 -> p2를 기준으로 p3, p4를 외적.
    // p3 -> p4를 기준으로 p1, p2를 외적.
    
    // cout << externalproduct(p1, p2, p3) << " " << externalproduct(p1, p2, p4) << endl;
    // cout << externalproduct(p3, p4, p1) << " " << externalproduct(p3, p4, p2) << endl;

    int case1 = externalproduct(p1, p2, p3) * externalproduct(p1, p2, p4);
    int case2 = externalproduct(p3, p4, p1) * externalproduct(p3, p4, p2);

    if(case1 == 0 && case2 == 0) {
        // 값 비교 필요.
        if(p1.x != p2.x) partcal(p1.x, p2.x, p3.x, p4.x);
        else             partcal(p1.y, p2.y, p3.y, p4.y);
        return 0;
    }
    else if(case1 <= 0 && case2 <= 0) cout << 1;
    else cout << 0;
}
