#include<iostream>

using namespace std;

long long fia[50] = { 0,1, };

long long fibonacci(int n) {
    if (n == 0 || n == 1) {
        return fia[n];
    }
    else if (fia[n] == 0) {
        fia[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
    return fia[n];
}

int main() {
    int T;
    cin >> T;

    int num;
    for (int i = 0; i < T; i++) {
        cin >> num;

        if (num == 0) cout << 1 << ' ' << 0 << '\n';
        else {
            cout << fibonacci(num - 1) << ' ' << fibonacci(num) << '\n';
        }
    }
}