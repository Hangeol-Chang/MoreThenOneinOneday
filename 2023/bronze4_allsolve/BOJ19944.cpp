#include <iostream>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    
    if((M - 1) / 2 == 0) cout << "NEWBIE!";
    else if (M <= N) cout << "OLDBIE!";
    else cout << "TLE!";
}
