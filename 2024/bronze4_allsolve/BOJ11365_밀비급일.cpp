#include <iostream>
#include <cstring>

using namespace std;

int main() {
    while(true) {
        char s[500];
        cin.getline(s, 500);

        if(strcmp(s, "END") == 0) return 0;

        int len = strlen(s);
        for(int l = len - 1; l >= 0; l--) cout << s[l];
        cout << "\n";
    }
}