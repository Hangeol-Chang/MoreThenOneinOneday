#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> abcs(26, 0);
    string str; cin >> str;

    for(char c : str) ++abcs[c - 'a'];
    for(auto i : abcs) cout << i << " ";
}