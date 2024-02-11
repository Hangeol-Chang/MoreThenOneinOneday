#include <iostream>

using namespace std;

int main() {
    int m, n; cin >> m >> n;
    int out = m * n;
    int in = (m-2) * (n-2);
    if(m-2 < 0 || n-2 < 0) in = 0;
    
    cout << out - in;
}