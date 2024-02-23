#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> socks(10, 0);
    
    for(int i = 0; i < 5; i++) {
        int a; cin >> a;
        socks[a] = 1 - socks[a];
    }
    for(int i = 0; i < 10; i++) {
        if(socks[i] == 1) {
            cout << i;
            break;
        }
    }
}