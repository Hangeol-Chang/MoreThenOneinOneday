#include <iostream>
#include <vector>

using namespace std;

struct coordi {
    int x;
    int y;
    
    coordi(int xin, int yin) : x(xin), y(yin) {};
};

int main() {
    int N;
    cin >> N;

    vector<coordi> coordis;
    
    for(int i = 1; i <= N; i++) {
        int tmpx, tmpy;
        cin >> tmpx >> tmpy;
        coordis.push_back(coordi(tmpx, tmpy));
    }

    long long Sx = 0;
    long long Sy = 0;
    long long Sxx = 0;
    long long Sxy = 0;
    for(vector<coordi>::iterator it = coordis.begin(); it != coordis.end(); it++) {
        Sx += it->x;
        Sy += it->y;
        Sxx += (it->x) * (it->x);
        Sxy += (it->x) * (it->y);
    }

    if(Sx * Sx == (long long)N * Sxx) {
        cout << "EZPZ";
    }
    else {
        double a = 1.0 * (N * Sxy - Sx * Sy) / (N * Sxx - Sx * Sx);
        double b = 1.0 * (Sy - a * Sx) / N;

        printf("%.8f %.8f", a, b);
    }
}