#include <iostream>

using namespace std;

int getZari(int n) {
    int zari = 0;

    while(n > 0) {
        n /= 10;
        ++zari;
    }
    return zari;
}

int pow(int a, int b) {
    int num = 1;
    while(b-- > 0) 
        num *= a;

    return num;
}

int main() {
    int N; cin >> N;

    // 자릿수 구하기.
    long long ans = 0;

    int zari = getZari(N);
    
    // 9, 90 900
    for(int i = 1; i < zari; i++) {
        ans += i * 9 * pow(10, i-1);
        // cout << ans << endl;
    } 

    long long a = pow(10, zari - 1);
    ans += (N - a + 1) * zari;

    cout << ans;
}