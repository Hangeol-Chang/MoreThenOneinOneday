#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> nums(10, 0);

    int sum = 0;
    for(int i = 0; i < 10; i++) {
        cin >> nums[i];
        sum += nums[i];
    }

    for(int n : nums) {
        if(sum - n == n) {
            cout << n;
            break;
        }
    }
}