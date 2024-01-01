#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        long long a;
        scanf("%lld", &a);
        printf("%lld\n", a*a);
    }
}