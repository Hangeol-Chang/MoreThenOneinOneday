#include <iostream>
#include <cstring>

using namespace std;

int main() {
    string mbti; cin >> mbti;

    int N; cin >> N;
    int ans = 0;
    for(int i = 0; i < N; i++) {
        string tmp; 
        cin >> tmp;
        if(strcmp(mbti.c_str(), tmp.c_str()) == 0) ++ans;
    }
    cout << ans;
}