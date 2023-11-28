#include <iostream>
#include <vector>

using namespace std;

struct set {
    int num;
    int cost;

    set(int n, int c) : num(n), cost(c) {};
};

int main() {
    int N;
    cin >> N;
    vector<set> sets;

    for(int i = 0; i < 2; i++) {
        int num, cost;
        cin >> num >> cost;
        sets.push_back(set(num, cost));
    }

    int ans = 2100000000;
    for(auto s = sets.begin(); s != sets.end(); s++) {
        int buyC = N / s->num;
        if(N % s->num) buyC++;

        ans = min(ans, buyC * s->cost);
    }
    cout << ans;
}