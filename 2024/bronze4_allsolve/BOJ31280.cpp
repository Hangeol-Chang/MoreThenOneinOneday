#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> nums(4, 0);
    for(int i = 0; i < 4; i++) cin >> nums[i];

    sort(nums.begin(), nums.end());

    cout << 1 + nums[1] + nums[2] + nums[3];
}
