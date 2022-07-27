#include<iostream>

using namespace std;

int main() {
    int sum = 0;
    for(int i = 0; i < 5; i++) {
        int tmp;
        cin >> tmp;
        sum += tmp;
    }
    cout << sum;
}