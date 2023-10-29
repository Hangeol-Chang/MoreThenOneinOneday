#include <iostream>

using namespace std;

int main() {
    int n; cin >> n;
    int seq = 0;
    for(int i = 0; i < n; i++) {
        int a; cin >> a;
        seq += a;
    }
    
    if(seq == 0) cout << "Stay";
    else if(seq > 0) cout << "Right";
    else cout << "Left";
}