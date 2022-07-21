#include<iostream>
#include<cmath>
#include<queue>

using namespace std;

struct loc {
    int x, y;  
};

int main() {
    loc a, b, c;
    cin >> a.x >> a.y >> b.x >> b.y >> c.x >> c.y;

    priority_queue<double> que;
    que.push(sqrt((pow(a.x - b.x, 2) + pow(a.y - b.y, 2))*1.0));
    que.push(sqrt((pow(c.x - b.x, 2) + pow(c.y - b.y, 2))*1.0));
    que.push(sqrt((pow(a.x - c.x, 2) + pow(a.y - c.y, 2))*1.0));

    double bd = que.top();
    que.pop();
    double m1 = que.top();
    que.pop();
    double m2 = que.top();
    que.pop();

    // printf("%.15f\n", bd);
    // printf("%.15f\n", m1 + m2);
    // printf("%.15f\n", m1);
    // printf("%.15f\n", m2);
    if((a.y == b.y && b.y == c.y) || (a.x - b.x)*1.0/(a.y-b.y) == (a.x - c.x)*1.0/(a.y - c.y)) {
        cout << "-1.0";
        return 0;
    }
    // bd + m1 * 2 - (m1 + m2) * 2
    else printf("%.15f", 2*(bd - m2));
}