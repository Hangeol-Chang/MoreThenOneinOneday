#include <iostream>

using namespace std;

int main() {
    int coup, tick; cin >> coup >> tick;
    int pay = tick;

    if(coup >= 5)   pay = min(pay, tick - 500);
    if(coup >= 10)  pay = min(pay, (int)(0.9*tick));
    if(coup >= 15)  pay = min(pay, tick - 2000);
    if(coup >= 20)  pay = min(pay, (int)(0.75*tick));

    if(pay < 0) pay = 0;
    cout << pay;
}