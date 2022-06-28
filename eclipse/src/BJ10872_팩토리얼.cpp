#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    long long ans = 1;
    while(N > 0) {
        ans *= N--;
    }
    cout << ans << endl;
}