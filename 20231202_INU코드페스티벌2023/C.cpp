#include <iostream>
#include <vector>

using namespace std;

struct coordi {
    int X, Y;
    coordi(int x, int y) : X(x), Y(y) {};
};

int N, R;

int ddistance(coordi a, coordi b) {
    return (a.X-b.X)*(a.X-b.X) + (a.Y-b.Y)*(a.Y-b.Y);
}


int main() {
    cin >> N >> R;
    R *= R;
    int minX = 100, maxX = -100, minY = 100, maxY = -100;
    
    vector<coordi> rices;
    for(int i = 0; i < N; i++) {
        int x, y; cin >> x >> y;
        rices.push_back(coordi(x, y));

        minX = min(minX, x);
        maxX = max(maxX, x);
        minY = min(minY, y);
        maxY = max(maxY, y);
    }

    int ans = 0;
    int ansX, ansY;

    // 모든 좌표에 후라이팬 놓아보면서 검사.
    for(int nowX = minX; nowX <= maxX; nowX++) {
        for(int nowY = minY; nowY <= maxY; nowY++) {
            int tmpans = 0;
            coordi now(nowX, nowY);
            
            for(auto rice = rices.begin(); rice != rices.end(); rice++) {
                if(ddistance(now, *rice) <= R) ++tmpans;
            }

            if(ans < tmpans) {
                ans = tmpans;
                ansX = nowX;
                ansY = nowY;
            }
        }
    }
    cout << ansX << " " << ansY;
}