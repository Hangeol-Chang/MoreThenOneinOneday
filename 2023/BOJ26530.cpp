#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        
        int N; cin >> N;
        double ans = 0.0;
        for(int n = 1; n <= N; n++) {
            string pummok;
            int count; double cost;
            cin >> pummok >> count >> cost;
            ans += count * cost;
        }
        printf("$%.2f\n", ans);
    }
}