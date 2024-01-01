#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    
    for(int t = 1; t <= T; t++) {
        int N; cin >> N;
        
        for(int n = 1; n <= N; n++) {
            int a, b; cin >> a >> b;
            cout << a + b << " " << a * b << "\n";
        }
    }
}
