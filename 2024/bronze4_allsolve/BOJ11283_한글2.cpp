#include <iostream>
#include <string>
#include <cstddef>

using namespace std;

int main() {
    string s;
    cin >> s;

    int mem[3]; 

    // for (int i = 0; i < 3; i++) {
    //     int data = (int)s[i];
    //     if(data < 0) data += 256;
    //     mem[i] = data;
    // }
    int N = 0;
    N += ((s[0]&255) - 234) * 64 * 64;
    N += ((s[1]&255) - 176) * 64;
    N += ((s[2]&255) - 127);
    cout << N;
} 