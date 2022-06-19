#include <iostream>

using namespace std;

int main() {
    char arr[1000002];
    cin.getline(arr, 1000002, '\n');
    
    bool jud = true;
    int ans = 0;
    for(int i = 0; i < 1000002; i++){        
        if(arr[i] == NULL) {
            if(!jud) ans++;
            break;
        }
        else if(arr[i] == ' '){
            if(i == 0) continue;
            ans++;
            jud = true;
        }
        else jud = false;
    }
    cout << ans;
}