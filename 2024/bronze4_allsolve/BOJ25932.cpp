#include <iostream>
#include <vector>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        vector<int> nums;
        bool zack = false;
        bool mack = false;
        for(int i = 0; i < 10; i++) {
            int tmp; cin >> tmp;
            if(tmp == 17) zack = true;
            else if (tmp == 18) mack = true;

            nums.push_back(tmp);
        }

        for(auto num : nums) cout << num << " ";
        cout << "\n";
        if(mack && zack) cout << "both\n\n";
        else if(mack) cout << "mack\n\n";
        else if(zack) cout << "zack\n\n";
        else cout << "none\n\n";
    }
}