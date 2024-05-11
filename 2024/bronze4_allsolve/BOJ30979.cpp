#include <iostream>

using namespace std;

int main() {
    int F, T; cin >> F >> T;

    int sum = 0;
    for(int t = 0; t < T; t++) {
        int tmp; cin >> tmp;
        sum += tmp;
    }
    
    string ans = (sum >= F) ? "Happy" : "Cry";
    cout << "Padaeng_i " << ans;
    
}