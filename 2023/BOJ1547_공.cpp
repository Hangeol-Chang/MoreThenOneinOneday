#include <iostream>

using namespace std;

int main() {
    int M;
    cin >> M;
    
    int cups[4] = {0};
    cups[1] = 1;

    for(int i = 0; i < M; i++) {
        int f, s;
        cin >> f >> s;

        int save = cups[s];
        cups[s] = cups[f];
        cups[f] = save;
    }

    for(int i = 1; i <= 3; i++) {
        if(cups[i] == 1) {
            cout << i;
            return 0;
        }
    }
}