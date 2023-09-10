#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmpStr(string a, string b) {
    int alen = a.length();
    int blen = b.length();
    
    if(alen != blen) return alen < blen;
    else {
        for(int i = 0; i < alen; i++) 
            if(a[i] != b[i])
                return a[i] < b[i];
        
        return 0;
    }
}

int main() {
    int N; cin >> N;
    cin.ignore();

    vector<string> probs;
    vector<int> bojProbs;

    for(int i = 0; i < N; i++) {
        string inp;
        getline(cin, inp);

        if(inp.find("boj.kr/") != string::npos) bojProbs.push_back(stoi(inp.substr(7, 11)));
        else probs.push_back(inp);
    }

    sort(probs.begin(), probs.end(), cmpStr);
    sort(bojProbs.begin(), bojProbs.end());

    for(vector<string>::iterator it = probs.begin(); it != probs.end(); it++) cout << *it << "\n";
    for(vector<int>::iterator it = bojProbs.begin(); it != bojProbs.end(); it++) cout << "boj.kr/" << *it << "\n";
}

/*
8
read book
study gc
study3
studya
syuduu
boj.kr/1308
boj.kr/1
boj.kr/999


*/