#include<iostream>
#include<cmath>

using namespace std;

int main() {
    int num;
    cin >> num;
    
    int ans = 0;
    for(int i = 1; i <= 10000; i *= 10) {
        int p = (num / i) % 10;
        ans += pow(p, 5);
    }
    cout << ans;
}