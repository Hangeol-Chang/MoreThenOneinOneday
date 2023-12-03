#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> candis;

int b_search(int l, int r, int val) {
    
    while(l < r) {
        int mid = (l + r) / 2;
        
        if(candis[mid] >= val) l = mid + 1;
        else r = mid;
    }
    return l;
}

int main() {
    int N, a; cin >> N >> a;
    
    for(int i = 0; i < N-1; i++) {int tmp; cin >> tmp; candis.push_back(tmp);}
    sort(candis.rbegin(), candis.rend());

    int idx = b_search(0, N-1, a);
    cout << idx+1;
}