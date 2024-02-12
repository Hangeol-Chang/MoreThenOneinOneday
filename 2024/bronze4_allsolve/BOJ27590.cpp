#include <iostream>

using namespace std;

int main() {
    int ds, ys, dm, ym;
    cin >> ds >> ys >> dm >> ym;
    ds *= -1;
    dm *= -1;

    do {
        if(ds < dm) ds += ys;
        else        dm += ym;
    } while(ds != dm);

    cout << ds;
}