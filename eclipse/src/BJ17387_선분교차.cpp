#include <iostream>

using namespace std;

struct coordinate {
    long long x;
    long long y;
};

long long externalproduct(coordinate std, coordinate p1, coordinate p2) {
    coordinate dir1, dir2;
    dir1.x = p1.x - std.x;
    dir1.y = p1.y - std.y;

    dir2.x = p2.x - std.x;
    dir2.y = p2.y - std.y;

    long long res = dir1.x * dir2.y - dir1.y * dir2.x;
    return res;
}

int main() {
    // 좌표 두 개 받아서 교차 판단.
    coordinate p1, p2, p3, p4;

    cin >> p1.x >> p1.y >> p2.x >> p2.y;
    cin >> p3.x >> p3.y >> p4.x >> p4.y;
    // 입력 끝.

    // p1 -> p2를 기준으로 p3, p4를 외적.
    // p3 -> p4를 기준으로 p1, p2를 외적.
    long long case1 = externalproduct(p1, p2, p3) * externalproduct(p1, p2, p4);
    long long case2 = externalproduct(p3, p4, p1) * externalproduct(p3, p4, p2);

    if(case1 == 0 && case2 == 0) {
        // 값 비교 필요.
        int x1 = min(p1.x, p2.x);
        int x2 = max(p1.x, p2.x);
        
        int x3 = min(p3.x, p4.x);
        int x4 = max(p3.x, p4.x);

        if(x2 >= x3 && x1 < x4) cout << 1;
        else cout << 0;
    }
    else if(case1 < 0 && case2 < 0) cout << 1;
    else if((case1 == 0 && case2 < 0) ||
            (case2 == 0 && case1 < 0)) cout << 1;
    else cout << 0;
}

/*

2 -2 2 -5
2 -3 2 -4

-5 -3 2 5
-5 -3 1 0

4 3 -2 -5
-2 0 4 3

1 1 2 2
0 0 3 3

*/