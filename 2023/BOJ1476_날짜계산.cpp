#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct P {
    int c;
    int num;
    P(int cin, int nin) : c(cin), num(nin) {};
};

bool cmp(P a, P b) {
    if(a.num != b.num) {
        return a.num < b.num;
    }
    else return a.c < b.c;
}

bool checking(vector<P> v) {
    int cmpval = v[0].num;
    for(int i = 0; i < v.size(); i++) 
        if(v[i].num != cmpval) return false;
    return true;
}

int main() {
    vector<P> zip;
    vector<int> ppp = {15, 28, 19};
    for(int i = 0; i < 3; i++) {
        int tmp; cin >> tmp;
        zip.push_back(P(ppp[i], tmp));
    }

    while(!checking(zip)) {
        sort(zip.begin(), zip.end(), cmp);
        zip[0].num += zip[0].c;
    }

    cout << zip[0].num;
}