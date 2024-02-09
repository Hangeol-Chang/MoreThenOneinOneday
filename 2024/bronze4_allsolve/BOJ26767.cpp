#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;

    for(int n = 1; n <= N; n++) {
        int flag = 0;

        if(n % 7  == 0) flag += 7;
        if(n % 11 == 0) flag += 11;

        if(flag == 18) { cout << "Wiwat!\n"; goto nextp; }
        if(flag == 11) { cout << "Super!\n"; goto nextp; }
        if(flag == 7 ) { cout << "Hurra!\n"; goto nextp; }
        cout << n << "\n";

        nextp:;
    }
}