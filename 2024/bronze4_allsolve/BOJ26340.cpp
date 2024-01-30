#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        vector<int> nums(2, 0);
        for(int i = 0; i < 2; i++) cin >> nums[i];
        int c; cin >> c;

        printf("Data set: %d %d %d\n", nums[0], nums[1], c);
        
        sort(nums.rbegin(), nums.rend());

        while(c-- > 0) {
            nums[0] = nums[0]/2;
            sort(nums.rbegin(), nums.rend());
        }
        printf("%d %d\n\n", nums[0], nums[1]);
    }
}