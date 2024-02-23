#include <iostream>
#include <string>

using namespace std;

int main() {
    int num; cin >> num;
    while(num % 10 == 0) num /= 10;
    // if(num % 10 == 0) num /= 10;

    string numstr = to_string(num);

    int ans = 0;

    for(int i = 0; i < numstr.length(); i++) {
        // if(numstr[i] != '0')
        //     continue;
        if(numstr[i] == '0') ans++;

        // int len = 0;
        // while(numstr[i] == '0') {
        //     i++;
        //     len++;
        // }
        // i--;
        // ans = max(len, ans);
    }
    cout << ans;
} 