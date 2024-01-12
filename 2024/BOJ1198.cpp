#include <iostream>
#include <vector>

using namespace std;

struct coordi {
    int x, y;
    coordi(int xin, int yin) : x(xin), y(yin) {};
    coordi() : x(0), y(0) {};
};

vector<coordi> coordis;
double ans = 0.0;
int N;

void checkans(vector<coordi> selected) {
    coordi c1 = selected[0];
    coordi c2 = selected[1];
    coordi c3 = selected[2];

    int p1 = c1.x*c2.y + c2.x*c3.y + c3.x*c1.y;
    int p2 = c2.x*c1.y + c3.x*c2.y + c1.x*c3.y;

    double tmpans = 0.5 * (p1 - p2);
    if(tmpans < 0) tmpans *= -1;

    // cout << tmpans << "\n";
    if(tmpans > ans) ans = tmpans;
}

// 조합해서 끈공식 넓이
void select(vector<coordi> selected, int sel, int idx) {
    if(sel == 3) {
        checkans(selected);
        return;
    }
    
    for(int i = idx; i < N; i++) {
        selected[sel] = coordis[i];
        select(selected, sel + 1, i+1);
    }
}

int main() {
    cin >> N;
    coordis.reserve(N);

    for(int i = 0; i < N; i++) {
        int x, y; cin >> x >> y;
        coordis.push_back(coordi(x, y));
    }
    select(vector<coordi>(3, coordi()), 0, 0);
    printf("%.10f\n", ans);
}