#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<string> ans;
    string inp;
    while(getline(cin, inp)) {
        // if(inp[0] == '0') break;

        for(int i = 0; i < inp.size(); i++) {
            switch(inp[i]) {
                case 'i' :
                    inp[i] = 'e';
                    break;
                case 'e' :
                    inp[i] = 'i';
                    break;
                case 'I' :
                    inp[i] = 'E';
                    break;
                case 'E' :
                    inp[i] = 'I';
                    break;
                default :
                    break;
            }
        }
        ans.push_back(inp);
    }

    for(auto it = ans.begin(); it != ans.end(); it++) {
        cout << *it << "\n";
    }
}