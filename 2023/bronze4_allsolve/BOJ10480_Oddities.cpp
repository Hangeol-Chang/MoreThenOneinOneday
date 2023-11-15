#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    
    for(int t = 0; t < T; t++) {
        int n; cin >> n;
        std::string s = n % 2 == 0 ? "even" : "odd";
        
        cout << n << " is " << s << "\n";
    }
}