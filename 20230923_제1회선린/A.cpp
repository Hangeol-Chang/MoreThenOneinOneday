#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;
    
    for(int i = 1; i <= N; i++) {
        int a, x, b;
        cin >> a >> b >> x;
        cout << a * (x - 1) + b << "\n";
    }
}