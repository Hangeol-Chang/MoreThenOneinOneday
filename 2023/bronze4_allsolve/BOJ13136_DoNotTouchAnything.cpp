#include <iostream>

using namespace std;

int main() {
    int R, C, N; cin >> R >> C >> N;

    long long r = R / N;
    if(R % N) r += 1;
    long long c = C / N;
    if(C % N) c += 1;
    
    cout << r * c;
}