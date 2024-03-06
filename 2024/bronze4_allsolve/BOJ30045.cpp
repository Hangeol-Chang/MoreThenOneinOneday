#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;
    int ans = 0;
    for(int n = 1; n <= N; n++) {
        string inp; cin >> inp;

        int len = inp.length();
        for(int i = 0; i < len - 1; i++) {
            if(inp[i] == '0') {
                if(inp[i+1] == '1') {
                    ans++;
                    break;
                }
            }
            else if(inp[i] == 'O') {
                if(inp[i+1] == 'I') {
                    ans++;
                    break;
                }
            }
        }
    }
    cout << ans;
}