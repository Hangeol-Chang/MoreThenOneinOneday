#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

struct coordi {
    double x = 0.0;
    double y = 0.0;
};

struct angleS {
    int idx;
    double angle;

    angleS(int iin, double ain) : idx(iin), angle(ain) {};
    angleS();
};

double getLength(coordi *c1, coordi *c2) {
    double x = c1->x - c2->x;
    double y = c1->y - c2->y;
    return x*x + y*y;
}

coordi getCenter(vector<coordi> map) {
    int size = map.size();
    coordi cen;

    for(coordi c : map) {
        cen.x += c.x;
        cen.y += c.y;
    }
    
    cen.x /= size;
    cen.y /= size;

    return cen;
}

double getAngle(coordi *c1, coordi *c2) {
    return atan2(c2->y - c1->y, c2->x - c1->x);
}

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; ++t) {
        vector<coordi> map;
        
        for(int i = 0; i < 4; ++i) {
            coordi a;
            cin >> a.x >> a.y;
            map.push_back(a);
        }

        coordi center = getCenter(map);

        for(int i = 0; i < 4; i++) {
            map[i].x -= center.x;
            map[i].y -= center.y;
        }

        coordi ynv; // y Normalized Vector
        ynv.x = 0;
        ynv.y = 0;

        vector<angleS> angles;

        for(int i = 0; i < 4; i++) {
            coordi c = map[i];
            double angle = getAngle(&ynv, &c) * 180/3.1415926;

            if(angle < 0) angle = 360 + angle;
            angles.push_back(angleS(i, angle));
        }
        sort(angles.begin(), angles.end(), [] (const angleS& a, const angleS& b) {
            return a.angle < b.angle;
        });
        
        bool isSquare = 0;

        double basis = getLength(&map[angles[0].idx], &map[angles[3].idx]);

        // 검증2 : 대각선의 길이.
        double crosslen1 = getLength(&map[angles[0].idx], &map[angles[2].idx]);
        double crosslen2 = getLength(&map[angles[1].idx], &map[angles[3].idx]);
        if(crosslen1 != crosslen2) {
            // cout << crosslen1 << " " << crosslen2 << endl;
            goto endFrame;
        }

        // 검증1 : 네 변의 길이.
        for(int i = 0; i < 3; i++) 
            if(basis != getLength(&map[angles[i].idx], &map[angles[i+1].idx]))
            {
                coordi a = map[angles[i].idx];
                coordi b = map[angles[i+1].idx];
                // cout << "coordi : " << a.x << " " << a.y << " / " << b.x << " " << b.y << endl;
                // cout << "b : " << i << " " << basis << " " <<  getLength(&map[angles[i].idx], &map[angles[i+1].idx]) << endl;
                goto endFrame;
            }

        // 0/2, 1/3

        isSquare = true;
        endFrame:;
        printf("%d\n", isSquare);
    }
    
}