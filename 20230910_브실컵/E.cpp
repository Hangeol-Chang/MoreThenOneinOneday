#include <iostream>

using namespace std;

int main() {
    int N, M, K; cin >> N >> M >> K;

    int xM = N - (M * (K - 1)) - 1 ;
    int xm = N - (M * K);

    if(xm < 0) xm = 0;

    cout << xm << " " << xM;
}