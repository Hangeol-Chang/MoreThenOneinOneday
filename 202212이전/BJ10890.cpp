#include<iostream>
using namespace std;

int main() {
    string a;
    cin >> a;
    
    int ans[26];
    fill_n(ans, 26, -1);

    for(int i = 0; i < a.length(); i++) {
        int loc = a[i] - 'a';
        if(ans[loc] == -1) ans[loc] = i;
    }
    
    for(int n : ans) cout << n << " ";
}
