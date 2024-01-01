#include <iostream>

using namespace std;

int main() {
    int A, C, E, a, c, e;
    cin >> A >> C >> E >> a >> c >> e;

    if((C+1)/2 > c) { cout << "E"; goto endP; }
    if(C > c)       { cout << "D"; goto endP; }
    if((A+1)/2 > a) { cout << "C"; goto endP; }
    if(A > a)       { cout << "B"; goto endP; }
    cout << "A";

    endP:;
}