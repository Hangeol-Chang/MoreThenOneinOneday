#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;
    int d = 0;
    int p = 0;
    for(int i = 0; i < N; i++) {
        char c; cin >> c;
        if(c == 'D') ++d;
        else ++p;

        if(abs(d - p) >= 2) break;
    }
    printf("%d:%d\n", d, p);
}