#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, K;
    cin >> N >> K;

    vector<int> vec;
    for(int i = 0; i < N; i++) {
        int a;
        cin >> a;
        vec.push_back(a);
    }

    sort(vec.begin(), vec.end());

    int a = 0;
    int b = 0;
    int ans = 0;

    while(b < N) {
        if(vec[b] - vec[a] > K) a++;
        else {
            // cout << a << " " << b << endl;
            ans = max(ans, b++ - a + 1);
        }
    }
    cout << ans;
}