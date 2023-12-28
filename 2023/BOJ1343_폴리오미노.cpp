#include <iostream>
#include <iostream>

using namespace std;

int main() {
    string inp;
    cin >> inp;
    inp.append(".");

    int len = inp.length();
    int bufferSize = 0;

    for(int i = 0; i < len; i++) {
        if(inp[i] == '.' || bufferSize == 4) {
            if(bufferSize == 0) continue;
            if(bufferSize % 2 == 1) {cout << "-1"; return 0;}
            
            string rep = bufferSize == 2 ? "BB" : "AAAA";
            inp.replace(i - bufferSize, bufferSize, rep);

            bufferSize = 0;
        }
        
        if(inp[i] == 'X') bufferSize += 1;

        // cout << inp << " " << i << "\n";
    }

    cout << inp.substr(0, inp.length() - 1);
}