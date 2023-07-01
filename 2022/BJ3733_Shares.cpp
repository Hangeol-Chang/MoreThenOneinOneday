#include<iostream>

using namespace std;
int main() {
    int p, q;
    while( scanf("%d %d", &p, &q) == 2) {
        cout << q/(p+1) << "\n";
    } 
}