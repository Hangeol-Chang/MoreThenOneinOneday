#include <iostream>
#include <vector>

using namespace std;

int main() {
    int P; cin >> P;
    
    for(int p = 1; p <= P; p++) {
        vector<int> nums;
        int count = 0;

        for(int i = 0; i < 3; i++) {
            int n; cin >> n;
            if(n >= 10) ++count;
            nums.push_back(n);
        }

        string ans = "zilch";
        if(count == 3) ans = "triple-double";
        else if (count == 2) ans = "double-double";
        else if (count == 1) ans = "double";

        printf("%d %d %d\n%s\n\n", nums[0], nums[1], nums[2], ans.c_str());
    }
}