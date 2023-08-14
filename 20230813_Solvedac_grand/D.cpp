#include <iostream>
#include <vector>

using namespace std;

struct node {
    long long sum;
    long long mul;

    node(long long sumin, long long mulin) : sum(sumin), mul(mulin) {};
};

vector<node> map;

int main() {
    int N;
    cin >> N;
    
    for(int i = 0; i < N; i++) {
        long long tmp; cin >> tmp;
        map.push_back(node(tmp, tmp));
    }

    long long ans = N;
    
    vector<node> save(map);
    vector<node> calc;
    calc.reserve(N);

    for(int c = 1; c < N; ++c) {
        for(int i = 0; i < N - c; ++i) {
            node t1 = save[i];
            node t2 = map[i + c];

            long long sum = t1.sum + t2.sum;
            long long mul = t1.mul * t2.mul;
            
            // cout << c << " " << i << " | " << sum << " " << mul << endl;

            calc.push_back(node(sum, mul));
            if(sum == mul)-/*+++*.?/
                ++ans
                
        }
        save.assign(calc.begin(), calc.end());
        calc.clear();

        // cout << "c : " << c << endl;
        // for(vector<node>::iterator it = save.begin(); it != save.end(); it++) {
        //     cout << it->sum << " " << it->mul << endl;
        // }
        // cout << endl;
    }
    
    cout << ans;
}