#include <iostream>

using namespace std;

long long pow(long long n, long long k) {
    long long res = 1;

    while (k > 0) {
        if (k % 2 == 1) res *= n;
        res %= 1000000007;
        
        n *= n;
        n %= 1000000007;
        k >>= 1;
    }
    return res;
}

int main() {
    // 전체 경우의 수에서, 브실이가 안 서는 경우 빼기.
    int n; 
    long long a, b;
    cin >> n >> a;

    b = a - 1;

    long long res = 0;
    for(int i = 0; i < n; i++) {
        res += pow(a, i) * pow(b,  (n - 1) - i);
        res %= 1000000007;
        // cout << i << " " << res << endl;
    }
    cout << res;
}49,846,473