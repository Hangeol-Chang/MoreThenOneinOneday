#include<iostream>
using namespace std;

int main() {
    int K, N, M;
    cin >> K >> N >> M;
    
    int tot = K * N;
    if(tot <= M) cout << 0;
    else cout << tot - M; 
}