#include <iostream>

using namespace std;

int nums[2];
string ini;

void makeString() {
    cout << nums[0] << " " << nums[1] << " " << endl;

}

void makepair(int seleted, int now, int max) {
    if(seleted == 2) {
        makeString();
        return;
    }

    for(int i = 1; i < max-(1-seleted + now); i++) {
        nums[seleted] = i;
        makepair(seleted + 1, i, max);
    }
    return;
}

int main() {
    cin >> ini;
    makepair(0, 0, ini.length());
}


/*
abcdefghij

*/