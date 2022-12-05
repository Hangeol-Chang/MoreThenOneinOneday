#include<iostream>

using namespace std;

int main() {
    string a;
    while(true) {
        getline(cin, a);
        if(a == "#") return 0;

        int ans = 0;
        for(char c : a) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            ans++;
        }

        cout << ans << endl;
    } 
}