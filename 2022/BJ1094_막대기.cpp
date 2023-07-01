#include<iostream>

using namespace std;
int main() {
    int X;
    cin >> X;

    int len[7] = {64, 32, 16, 8, 4, 2, 1};

    int count = 0;
    int idx = 0;
    while(X > 0) {
        while(len[idx] > X) idx++;

        X -= len[idx];
        count++;
    }
    cout << count;
}