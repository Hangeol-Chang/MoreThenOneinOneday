#include <iostream>
#include <vector>

#define MAX_NUM 9876543210
using namespace std;

// vector<vector<int>> save(10, vector<int>(10, -1));

// 내 앞에 있는 수 > num, 계산할 위치의 10의 지수 > p
// int calcSamll(int num, int p) {
//     if(p == 0) {
//         return num - 1;
//     }
//     else {

//     }
// }

long long pow(long long alx, int wltn) {
    long long ret = 1;
    while(wltn-- > 0) {
        ret *= alx;
    }
    return ret;
}

int main() {
    // for(int i = 0; i < 10; i++) {
    //     save[0][i] = i;
    // }
    int N;
    cin >> N;

    int now = 0;
    long long num = 0;
    while (now < N) {
        // cout << "num : " << num;

        // max값 초과
        if(num > MAX_NUM) {
            cout << -1;
            return 0;
        }
        
        // num의 자릿수 구하기
        long long checknum = num;
        int zari = 0;
        while(checknum > 0) {
            zari++;
            // cout << zari << " ";
            checknum /= 10;
        }
        // cout << " | zari : " << zari << " ";

        int a  = 10;
        while(zari > 0) {
            long long power = pow(10L, --zari);
            int newa = ( num / power ) % 10;
            
            // 확 넘겨버릴 수 있음.
            if (newa >= a) {
                // zari + 1의 값
                num = (num - num % pow(10L, zari + 1) ) + pow(10L, zari + 1);
                goto outer;
            }
            else a = newa;
        }
        now++;
        num++;
        // cout << " | now : " << now;

        outer:;
        // cout << endl;
        // Sleep(100);
    }
    cout << num - 1;
}