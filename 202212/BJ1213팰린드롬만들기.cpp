#include <iostream>
#include <string>

using namespace std;

int main() {
    int count[26] = {0,};

    string ini;
    cin >> ini;
    
    for(char c : ini) count[c - 'A']++;
    int len = ini.length();

    char a[51] = {};
    char *ptr = a;
    *(ptr + len) = '\0';
    int now = 0;

    int odd = -1;
    for(int i = 0; i < 26; i++) {
        int t = count[i];

        while(count[i] >= 2) {
            count[i] -= 2;
            
            // cout << count[i] << " || " << now << " " << len-1 - now << "\n";

            *(ptr + now) = i + 'A';
            *(ptr + len-1 - now) = i + 'A';
            now++;
        }

        if(count[i] > 0) {
            if(odd >= 0) {
                cout << "I'm Sorry Hansoo";
                return 0;
            }
            else odd = i;
        }
    }

    if(odd >= 0) *(ptr + now) = odd + 'A';
    
    cout << a;
    return 0;
}

/*
AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB

*/