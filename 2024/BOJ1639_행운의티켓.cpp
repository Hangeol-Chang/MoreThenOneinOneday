#include <iostream>
#include <vector>

using namespace std;


bool checkLucky(vector<int> nums) {
    int halfLen = nums.size() / 2;

    int lSum = 0;
    int rSum = 0;

    for(int i = 0; i < halfLen; i++) {
        lSum += *(nums.begin()  + i);
        rSum += *(nums.rbegin() + i);
    }

    if(lSum == rSum) return true;
    else return false;
}

int main() {
    string inp;
    cin >> inp;
    
    vector<int> map;

    for(char c : inp) map.push_back(c - '0');
    int ans = 0;
    int maxlen = map.size();

    for(int l = 2; l <= maxlen; l += 2) {

        for(int i = 0; i <= maxlen - l; i++) {
            vector<int> mapPart(l);
            copy(map.begin() + i, map.begin() + i + l, mapPart.begin());
            
            // for(int p : mapPart) cout << p;
            // cout << "\n";

            bool check = checkLucky(mapPart);

            if(check) {
                ans = l;
                break;
            }
        }
        // cout << "\n";
    }

    cout << ans;
}