#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int a = n * 78 / 100;
    int eit = n * 80 / 100;
    int per = (n * 20 / 100) * 78 / 100;

    cout << a << " " << eit + per;    
}