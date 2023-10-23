#include <iostream>

using namespace std;

int main() {
    string tmp;
    int ans = 0;
    while(getline(cin, tmp)) {
        ++ans;
    }
    cout << ans;
}