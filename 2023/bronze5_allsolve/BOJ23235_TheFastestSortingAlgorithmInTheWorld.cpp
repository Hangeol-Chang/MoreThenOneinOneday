#include <iostream>
#include <sstream>
#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)

using namespace std;

int main() {
    fastio;
    
    int i = 0;
    while(true) {
        string line;
        getline(cin, line);

        istringstream ss(line);
        string buffer;
        getline(ss, buffer);
        if(buffer == "0") return 0;
        // if(stoi(buffer) == 0) return 0;
        
        cout << "Case " << ++i << ": Sorting... done!\n";
    }
}