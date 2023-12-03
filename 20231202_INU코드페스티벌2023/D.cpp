#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<long long> sharks;
int binary_search(int l, int r, int var) {
    int size = r;

    while(l < r) {
        int mid = (l + r) / 2;
        
        if(var <= sharks[mid]) r = mid;
        if(var > sharks[mid]) l = mid + 1;

    }
    return r;
}

int main() {
    // 상어 마릿수, 먹을 수 있는 최대 마릿수, 샼의 최초 크기.
    int N, K;
    long long T;
    cin >> N >> K >> T;
    
    for(int n = 0; n < N; n++) {
        long long tmp;
        cin >> tmp;
        sharks.push_back(tmp);
    }
    sort(sharks.begin(), sharks.end());

    while(K-- > 0) {
        int idx = binary_search(0, sharks.size() - 1, T);
        if(idx < 0) break;
        if(sharks[idx] >= T) idx--;
        if(idx < 0) break;

        long long val = sharks[idx];
        sharks.erase(sharks.begin() + idx);
        
        // cout << T << " " << idx << " " << val << "\n";
        // for(auto it = sharks.begin(); it != sharks.end(); it++) cout << *it << " ";
        // cout << endl;

        T += val;
    }
    
    cout << T;
}