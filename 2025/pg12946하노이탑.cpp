#include <string>
#include <vector>

using namespace std;

vector<vector<int>> move(int height, int from, int to) {
    int oth = 6 - (from + to);
    
    if(height > 1) {
        vector<vector<int>> ans = move(height-1, from, oth);
        ans.push_back({from, to});
        vector<vector<int>> ans_rem = move(height-1, oth, to);
        ans.insert(ans.end(), ans_rem.begin(), ans_rem.end());
        return ans;
    }
    else {
        return {{from, to}};
    }
}

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer = move(n, 1, 3);
    return answer;
}