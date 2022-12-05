#include<iostream>
using namespace std;

int main() {
    int add, dep;
    cin >> add >> dep;
    
    int a = (add + dep)/2;
    int b = (add - dep)/2;

    if(a < 0 || b < 0 ||
       a + b != add || a - b != dep ) {
        
        cout << -1;
        return 0;
    }
    cout << a << " " << b;
}