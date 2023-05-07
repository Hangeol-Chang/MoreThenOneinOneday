#include <iostream>

using namespace std;

int main() {
    
    int count;
    cin >> count;

    int sum = 1;
    for (int i = 1; i <= count; i++) {
        int num;
        cin >> num;

        sum += num - 1;
    }
    cout << sum << endl;
}