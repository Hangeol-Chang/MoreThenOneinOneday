/*
 1 9 17 < 8n + 1
 2 8 10 16 18 < 8n or 8n + 2
 3 7 11 15 19 < 8n + 3, 8n + 7
 4 6 12       < 4, 6
 5 13         < 5
*/
#include <iostream>

using namespace std;

int main() {
    int n; cin >> n;
    int q = n % 8;
    
    if(q == 1) cout << 1;
    else if(q == 0 || q == 2) cout << 2;
    else if(q == 3 || q == 7) cout << 3;
    else if(q == 4 || q == 6) cout << 4;
    else cout << 5;
}
