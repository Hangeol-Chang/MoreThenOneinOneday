#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, target;
    cin >> n >> target;

    vector<int> vec;

    for(int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        vec.push_back(tmp);
    }

    int ans = 0;
    for(int l = 0; l < n; l++){
        for(int r = l+1; r < n; r++){
            int sum = vec[l] + vec[r];
            if(sum <= target) ans++;
        }
    }
    cout << ans << endl;
}