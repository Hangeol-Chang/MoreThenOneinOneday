#include<iostream>
#include<algorithm>

using namespace std;

int main() {
    int scores[2] = {0};
    
    for(int n = 0; n < 2; n++)
        for(int i = 0; i < 4; i++) {
            int tmp;
            cin >> tmp;
            scores[n] += tmp; 
        }
    
    int ans = max(scores[0], scores[1]);
    cout << ans;
}
