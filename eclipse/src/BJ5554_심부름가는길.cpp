#include<iostream>

using namespace std;

int main() {
    int tottime = 0;
    for(int i = 0; i < 4; i++) {
        int tmp; cin >> tmp;
        tottime += tmp;
    }
    int m = tottime / 60;
    int s = tottime % 60;
    cout << m << "\n" << s;
}