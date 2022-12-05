#include<iostream>

using namespace std;
int main() {
    int res = 0;
    for(int i = 0; i < 5; i++) {
        int tmp; cin >> tmp; 
        if(tmp < 40) tmp = 40;
        res += tmp;
    }
    cout << res/5;
}