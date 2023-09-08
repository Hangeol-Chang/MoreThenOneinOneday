#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool cmpStringLen(string a, string b) {
    return b.length() < a.length();
}

int main() {
    int N;
    cin >> N;

    vector<string> vec;
    for(int i = 0; i < N; i++) {
        string tmp;
        cin >> tmp;
        vec.push_back(tmp);
    }

    sort(vec.begin(), vec.end(), cmpStringLen);
    
    vector<string> ans;
    for(vector<string>::iterator it = vec.begin(); it != vec.end(); it++) {        
        for(vector<string>::iterator it2 = ans.begin(); it2 != ans.end(); it2++) {
            int size = (*it).size();

            // cout << it2->substr(0, size) << " " << *it << " " << it2->substr(0, size).compare(*it) << endl;
            if( it2->substr(0, size).compare(*it) == 0 )
                goto outer;
        }
        ans.push_back(*it);
        // cout << *it << endl;

        outer:;
        // cout << endl;
    }
    cout << ans.size();
}