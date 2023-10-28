#include <iostream>

using namespace std;

int main() {
    long long N; cin >> N;
    long long ans = 1;
    while(N >= 1) 
        ans *= N--;
    
    cout << ans;
}