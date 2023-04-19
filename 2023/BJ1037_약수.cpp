
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    vector<int> arr;
    for(int i  = 0; i < n; i++ ) {
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
    }
    sort(arr.begin(), arr.end());

    int num;
    for(auto a : arr) {
        num = arr[n-1] * a;        
        
        for (int t : arr)
            if( !(num % t == 0) )
                goto outer;
        break;
        outer:;    
    }

    cout << num;
    return 0;
}

// 진짜 코드 대충짜네..