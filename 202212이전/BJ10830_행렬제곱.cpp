#include <iostream>

using namespace std;

static int psize;

int** calc(int** p1, int** p2){
    int** newp = new int*[psize];
    for(int i = 0; i < psize; i++) newp[i] = new int[psize];

    for(int i = 0; i < psize; i++) {
        for(int j = 0; j < psize; j++) {
            int tmp = 0;
            
            for(int t = 0; t < psize; t++)
                tmp += p1[i][t] * p2[t][j];

            newp[i][j] = tmp % 1000;
        }
    }
    return newp;
}

int** multiple(long long n, int** p){
    if(n == 1) return p;

    int** x = multiple(n/2, p);
    int** mx = calc(x, x);

    if(n % 2 == 0) return mx;
    else           return calc(mx, p);
}

int main() {
    long long num;
    cin >> psize >> num;

    // 배열 생성 및 초기화
    int** p = new int*[psize];
    for(int i = 0; i < psize; i++) {
        p[i] = new int[psize];
        
        for(int j = 0; j < psize; j++) {
            int tmp;
            cin >> tmp;
            p[i][j] = tmp % 1000;
        }
    }

    int** ans = multiple(num, p);

    for(int i = 0; i < psize; i++) {
        for(int j = 0; j < psize; j++)
            cout << ans[i][j] << " ";
        cout << endl;
    }
}