#include <iostream>

using namespace std;

int main() {
    // 좌표 두 개 받아서 교차 판단.
    long long x1, y1, x2, y2;
    long long x3, y3, x4, y4;

    cin >> x1 >> y1 >> x2 >> y2;
    cin >> x3 >> y3 >> x4 >> y4;

    long long denominator = (y4-y3)*(x2-x1)-(x4-x3)*(y2-y1);
    long long numerator1  = (x4-x3)*(y1-y3)-(y4-y3)*(x1-x3);
    long long numerator2  = (x2-x1)*(y1-y3)-(y2-y1)*(x1-x3);

    // cout << denominator << " " << numerator1 << " " << numerator2 << endl;
    if(denominator == 0) {
        // 직선이 겹침.
        if(numerator1 == 0) { 
            // 작은 값만 가져오기.
            long long sx1 = min(x1, x2);
            long long sx3 = min(x3, x4);
            
            long long bx1 = max(x1, x2);
            long long bx3 = max(x3, x4);
            
            if(sx1 < sx3) {
                if(bx1 < sx3) {
                    cout << 0; return 0;
                }
            }
            else if(sx1 > sx3) {
                if(bx3 < sx1) {
                    cout << 0; return 0;
                }
            }
            cout << 1; return 0; 
        }
        
        // 평행
        cout << 0;
        return 0;
    }

    // 정석 판단.
    double t = numerator1*1.0/denominator;
    double s = numerator2*1.0/denominator;

    // cout << t << " " << s << endl;
    if( s < 0 || s > 1 || t < 0 || t > 1) cout << 0;
    else                                  cout << 1;
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