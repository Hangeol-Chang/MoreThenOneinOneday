#include<iostream>

using namespace std;

int main() {
    int ans = 0;
    for(int i = 0; i < 6; i++) {
        int tmp;
        cin >> tmp;
        ans += tmp;
    }
    cout << ans * 5;
}