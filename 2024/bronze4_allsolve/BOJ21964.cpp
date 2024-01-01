#include <iostream>
#include <string>

using namespace std;

int main() {
    int N; cin >> N;
    string inp; cin >> inp;

    cout << inp.substr(N-5, 5);
}