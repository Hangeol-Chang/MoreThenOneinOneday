#include <iostream>
#include <vector>

using namespace std;

int main() {
    string inp; cin >> inp;
    vector<int> scores(2, 0);

    int len = inp.length();

    for(int i = 0; i < len; i += 2) {
        scores[inp[i] - 'A'] += inp[i+1] - '0';
    }
    if(scores[0] > scores[1]) cout << "A";
    else cout << "B";
}