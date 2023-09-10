#include <iostream>

using namespace std;

int main() {
    int size, N, M;
    cin >> size >> N >> M;
    
    int stk = 0;
    int order = N + M;
    for(int i = 0; i < N + M; i++) {
        int ord;
        cin >> ord;
        
        if(ord == 1) {
            stk++;
            if (stk > size) size *= 2;
        }
        else {
            stk--;
        }
    }
    cout << size;
}