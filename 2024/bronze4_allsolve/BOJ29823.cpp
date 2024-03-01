#include <iostream>

using namespace std;

int main() {
    int NS = 0;
    int WE = 0;

    int N; cin >> N;
    string move; cin >> move;

    for(char c : move) {
        if(c == 'N') NS += 1;
        else if(c == 'S') NS -= 1;
        else if(c == 'W') WE -= 1;
        else WE += 1;
    }

    cout << abs(NS) + abs(WE);
}