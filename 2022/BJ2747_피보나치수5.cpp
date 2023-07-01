#include<iostream>
#include<vector>

using namespace std;

int main() {
    int n;
    cin >> n;

    if(n <= 1) {
        cout << n << endl;
        return 0;
    }
    // 슬라이딩윈도우 걸어볼까?
    vector<int> fibo;
    fibo.push_back(0);
    fibo.push_back(1);
    

    for(int i = 2; i <= n; i++) {
        int a = fibo[0];
        int b = fibo[1];
        fibo.push_back(a + b);
        fibo.erase(fibo.begin());
    }
    cout << fibo[2];
    return 0;
}