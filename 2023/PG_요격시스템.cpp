#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(vector<int> a, vector<int> b) {
    return a[1] < b[1];
}

int solution(vector<vector<int>> targets) {
    
    sort(targets.begin(), targets.end(), cmp);

    int m = 0;
    int answer = 0;
    for(vector<vector<int>>::iterator it = targets.begin(); it != targets.end(); it++) {
        if(m <= (*it)[0]) {
            answer++;
            m = (*it)[1];
        }
    }
    
    return answer;
}