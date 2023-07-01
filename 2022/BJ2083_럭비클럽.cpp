#include<iostream>

using namespace std;

int main() {
    while(true) {
        string a;
        int age, w;
        cin >> a >> age >> w;
        if(a == "#") break;

        cout << a;
        if( age > 17 || w >= 80 ) cout << " Senior\n";
        else cout << " Junior\n";  
    }
}