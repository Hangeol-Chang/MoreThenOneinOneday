#include <iostream>
#include <map>
#include <string>

using namespace std;

map<string, int> sells;

int main() {
    int inp;
    cin >> inp;
    
    for(int i = 0; i < inp; i++) {
        string tmp;
        cin >> tmp;

        if(sells.find(tmp) != sells.end()) {
            sells[tmp]++;
        }
        else sells.insert({tmp, 1});
    }

    // cout << "\n";

    string ans;
    int max = 0;
    for(auto iter = sells.begin(); iter != sells.end(); iter++) {
        // cout << iter->first << " " << iter->second << "\n";
        
        if(max < iter->second) {
            ans = iter->first;
            max = iter->second;
        }

    }
    
    cout << ans;
}