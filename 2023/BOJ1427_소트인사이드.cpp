#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int input;
    cin >> input;
    
    vector<int> nums;
    while(input > 0) {
        nums.push_back(input % 10);
        input /= 10;
    }
    
    sort(nums.rbegin(), nums.rend());
    for(vector<int>::iterator it = nums.begin(); it != nums.end(); it++) {
        cout << *it;
    }
}