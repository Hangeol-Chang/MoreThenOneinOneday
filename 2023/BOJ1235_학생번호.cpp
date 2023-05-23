#include <iostream>
#include <set>
#include <vector>
#include <cstring>

// fail > Segfault

using namespace std;

int main() {
    set<string> a;
    vector<char *> input;

    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        char *tmp = (char *)malloc(100);
        cin >> tmp;
        input.push_back(tmp);
    }

    int len = 0;
    for(char *c = input[0]; *c != '\0'; c++) { len++; } 
    int totlen = len;

    while(true) {
        a.clear();

        len--;
        for(vector<char *>::iterator it = input.begin(); it != input.end(); it++) {

            pair<set<string>::iterator, bool> res = a.insert(string(*it + len));
            cout << *(res.first) << endl;
            if(!res.second) goto cont; 
        }

        break;
        cont:;
        cout << endl;
    }

    cout << totlen - len;
}