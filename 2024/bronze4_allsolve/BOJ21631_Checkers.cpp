#include <iostream>

using namespace std;

int main() {
    long long w, b;
    cin >> w >> b;

    long long maxNum = w + 1;
    if(maxNum > b) maxNum = b;
    cout << maxNum;
}
