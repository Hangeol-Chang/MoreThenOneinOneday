#include <iostream>
#include <string>

using namespace std;

int main() {
    int N; cin >> N;
    int ans = 0;
    for(int n = 1; n <= N; n++) {
        string t; cin >> t;
        int v = stoi(t.substr(2));
        if(v <= 90) ++ans;
    }
    cout << ans;
}