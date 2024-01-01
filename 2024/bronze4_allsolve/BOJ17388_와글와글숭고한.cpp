#include <iostream>

using namespace std;

int main() {
    int S, K, H;
    cin >> S >> K >> H;
    int sum = S + K + H;

    if(sum >= 100) cout << "OK";
    else {
        int m = min(S, min(K, H));
        
        if(m == S) cout << "Soongsil";
        else if(m == K) cout << "Korea";
        else cout << "Hanyang";
    }
}