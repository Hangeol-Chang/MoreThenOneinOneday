#include <iostream>

using namespace std;

int main() {
    int n; cin >> n;
    int r = (n-1) / 8 + 1;
    int c = (n-1) % 8;

    printf("%c%d", c+'a', r);
}