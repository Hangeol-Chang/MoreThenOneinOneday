#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;

    int price = 0;
    for(int n = 0; n < N; n++) {
        int tmp; cin >> tmp;
        price += tmp;
    }   
    cout << price;
}