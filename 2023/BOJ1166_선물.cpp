#include <iostream>
#include <algorithm>

using namespace std;

bool isSame(double a, double b) {
    if(b - a >= 0.0000000000001) return true;
    else return false;
}

int main() {
    long long N, L, W, H;
    cin >> N >> L >> W >> H;
    
    // 상자의 크기가 1보다 작아질 수 있는거 아닌가
    double l = 0.0000000001;
    double r = min(L, min(W, H)) * 1.0;

    // if(N == 1) { cout << r; return 0; }

    int count = 0;
    while(isSame(l, r) && count++ < 10000) {    
        double val = (l + r) / 2.0;
        long long calc = (long long)(L / val) * (long long)(W / val) * (long long)(H / val);

        // printf("%.11f %.11f || %.11f %d\n", l, r, val, calc);
        // 더 적게 들어가면, 사이즈를 줄여야함.
        if(calc < N) r = val;
        else l = val;
    }

    // printf("%.11f %.11f\n", l, r);
    printf("%.11lf", l);
}