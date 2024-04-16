#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;
    for(int n = 1; n <= N; n++) {
        int ans = 0;
        for(int i = 0; i < 5; i++) {
            int inp; cin >> inp;
            if(ans < inp) ans = inp;
        }
        printf("Case #%d: %d\n", n, ans);
    }
}