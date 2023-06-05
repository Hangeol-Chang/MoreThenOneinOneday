#include <iostream>

using namespace std;

int pow(int alx, int wltn) {
    int num = 1;
    while(wltn-- > 0) {
        num *= alx;
    } 
    return num;
}

int main() {
    int st, ed;
    cin >> st >> ed;

    int tmpnum = st;
    int power = -1;
    // st의 자릿수를 기준으로, ed가 st보다 자릿수가 크면 무조건 0
    while(tmpnum > 0) {
        power++;
        tmpnum /= 10;
    }

    int count8 = 0;
    while(power >= 0) {
        // 앞에서부터 한 자리씩에 대해서만 판단.
        int n1 = (st / int(pow(10, power))) % 10;
        if(n1 == 8) {
            int num = pow(10, power);
            int newnum = st - (st % num) + num;
            if (newnum <= ed) {
                // st = newnum;
                cout << count8;
                return 0;
            }
            else count8++;
        }
        power--;
    }
    cout << count8;
}