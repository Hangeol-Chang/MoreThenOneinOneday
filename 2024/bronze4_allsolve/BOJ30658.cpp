#include <iostream>
#include <vector>

using namespace std;

int main() {
    while(true) {
        int N; cin >> N;
        if(N == 0) return 0;

        vector<int> nums;
        for(int n = 0; n < N; n++) {
            int inp; cin >> inp;
            nums.push_back(inp);
        }

        for(auto it = nums.rbegin(); it != nums.rend(); it++) {
            cout << *it << "\n";
        }
        cout << "0\n";
    }
}