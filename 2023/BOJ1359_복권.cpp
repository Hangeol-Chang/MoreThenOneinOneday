#include <iostream>

using namespace std;

int nCm(int n, int m) {  
    int ans = 1;
    int c = 0;
    while(c++ < m)  ans *= n--;
    while(m > 1)    ans /= m--;
    return ans;
}

int main() {
    int n, m, k;
    cin >> n >> m >> k; 
    
    int totCount = nCm(n, m);
    int su = 0;
    for(int p = k; p <= m; p++) {
        su += nCm(m, p) * nCm(n - m, m - p);
    }
    
    printf("%.15f", su * 1.0 / totCount);
}