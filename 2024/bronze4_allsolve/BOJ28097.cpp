#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;
    int toth = -8;
    for(int i = 0; i < N; i++) {
        int tmp; cin >> tmp;
        toth += tmp + 8;
    }

    int day = toth / 24;
    int hou = toth % 24;
    cout << day << " " << hou;
}