#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N; cin >> N;
    vector<string> ans;

    for(int i = 0; i < N; i++) {
        string inp;
        cin >> inp;
        for(int i = 0; i < inp.size(); i++) 
            if(inp[i] < 91) inp[i] += 32;
        
        ans.push_back(inp);
    }
    for(string a : ans) cout << a << "\n";
}