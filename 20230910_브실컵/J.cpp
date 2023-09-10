#include <iostream>
#include <vector>
#include <unordered_set>

// fail
using namespace std;

struct loc {
    int r;
    int c;
    
    loc(int rin, int cin) : r(rin), c(cin) {}

};

namespace std {
    template<> struct hash<loc> {
        size_t operator()(const loc &l) const {
            size_t h1 = hash<int>{}(l.r);
            size_t h2 = hash<int>{}(l.c);
            
            return h1 ^ h2;
        }
    };
}
bool operator==(const loc &l1, const loc &l2) {
    return l1.r == l2.r && l1.c == l2.c;
}

int main() {
    int N, K;
    cin >> N >> K;

    vector<vector<int>> drdc = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
    unordered_set<loc> set;
    vector<loc> keep;

    for(int i = 0; i < K; i++) {
        int r, c; cin >> r >> c;
        keep.push_back(loc(r, c));

        for(vector<vector<int>>::iterator dd = drdc.begin(); dd != drdc.end(); dd++) {
            int nr = r + (*dd)[0];
            int nc = c + (*dd)[1];
            loc now(nr, nc);

            if(nr < 1 || nr > N || nc < 1 || nc > N) continue;
            if(set.find(now) == set.end()) set.emplace(now);
        }
    }
    int ans = set.size();
    for(vector<loc>::iterator it = keep.begin(); it != keep.end(); it++) {
        if(set.find(*it) != set.end()) ans--;
    }
    cout << ans;
}