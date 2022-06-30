#include <iostream>

using namespace std;

int ma[31];

int main() {
    for(int i = 1; i <= 28; i++) {
        int tmp;
        cin >> tmp;
        ma[tmp] = 1;
    }

    for(int i = 1; i <= 30; i++)
        if(ma[i] == 0) cout << i << endl;
}