#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> memory;

    int a, b, N;
    cin >> a >> b >> N;
    a %= b;

    int res = 0;
    bool run = true;
    while(N > 0 && run) {
        N--;
        a *= 10;
        res = a / b;
        // cout << a << " " << res << endl;
        a %= b;

        // 찾아진 곳부터 끝까지 반복해야함.
        // vector<int>::iterator it = find(memory.begin(), memory.end(), a);
        // if( it != memory.end() ) {

        // }

        // memory.
    }
    cout << res;
}