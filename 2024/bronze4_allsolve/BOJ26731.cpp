#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> alphabet(26, 0);
    
    string inp; cin >> inp;
    for(char c : inp) alphabet[c - 'A'] = 1;

    for(int i = 0; i < 26; i++)
        if(alphabet[i] == 0) {
            printf("%c", i + 'A');
            break;
        }
}