#include <iostream>

using namespace std;

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++) {
        int population, time; cin >> population >> time;

        population += time / 4;
        population -= time / 7;
        cout << population << "\n";
    }   
}