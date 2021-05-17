#include<iostream>

using namespace std;
int c0 = 0, c1 = 0;

int fibonacci(int n) {
    if (n == 0) {
        c0++;
        return 0;
    }
    else if (n == 1) {
        c1++;
        return 1;
    }
    else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

int main() {
    int T;

    cin >> T;

    int num;
    for (int i = 0; i < T; i++) {
        cin >> num;
        c0 = 0; c1 = 0;

        fibonacci(num);
        cout << c0 << ' ' << c1;
        cout << '\n';
    }
}