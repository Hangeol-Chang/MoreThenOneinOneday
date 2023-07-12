#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> nums;
vector<int> selected(3, 0);
int N;

int ans = -1;
void run(int selC, int idx) {
    if(selC == 3) {
        // cout << selected[0] << selected[1] <<  selected[2] << endl;
        if(selected[0] < selected[1] + selected[2])
            ans = selected[0] + selected[1] + selected[2];
        return;
    }
    else {
        for(int i = idx; i < N; i++) {
            if(ans > 0) return;
            if(selected[selC] == nums[i]) continue;

            selected[selC] = nums[i];
            for (int j = selC + 1; j < 3; j++) selected[j] = -1;
            run(selC + 1, i + 1);
        }
    }
}

int main() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        int tmp; cin >> tmp;
        nums.push_back(tmp);
    }

    sort(nums.rbegin(), nums.rend());
    run(0, 0);
    
    cout << ans;
}