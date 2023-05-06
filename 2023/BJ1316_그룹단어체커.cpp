#include <iostream>

using namespace std;

int main() {
    int count;
    cin >> count;

    int ans = 0;
    for(int i = 0; i < count; i++) {
        string str;
        cin >> str;
        int map[27] = {0};
        
        bool pass = false;
        char cash = '{';
        for(char c : str) {
            if(map[c - 'a'] == 1) goto outer;

            if (c != cash) map[cash - 'a'] = 1;
            cash = c;
        }
        pass = true;

        outer:;
        if (pass) ans++;        
    }
    cout << ans;

    return 0;
}