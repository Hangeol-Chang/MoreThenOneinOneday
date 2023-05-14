#include <iostream>
#include <vector>

using namespace std;

vector<pair<int, int>> dp(46, make_pair(0, 0));
vector<bool> maked(46, 0);

pair<int, int> run(int num) {
    if(maked[num]) return dp[num];

    pair<int, int> bef = run(num-1);
    
    int a = bef.second;
    int b = bef.first + bef.second;
    dp[num] = make_pair(a, b);
    maked[num] = 1;
    return dp[num];
}


int main() {
    dp[0] = make_pair(1, 0);
    maked[0] = 1;

    int inp;
    cin >> inp;

    pair<int, int> res = run(inp);
    cout << res.first << " " << res.second;
}