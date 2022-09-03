#include<iostream>

using namespace std;

int main() {
    int ans = 0;

    for(int r = 1; r <= 8; r++) {
        string read;
        cin >> read;
        
        for(int c = 1; c <= 8; c++) {
            if(read[c-1] == 'F')
                if((c + r) % 2 == 0)
                    ans++;
        }
    }
    cout << ans;
}