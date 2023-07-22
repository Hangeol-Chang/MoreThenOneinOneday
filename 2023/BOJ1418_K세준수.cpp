#include <iostream>
#include <vector>
#include <cmath>

using namespace std;


int main() {
    // 소수를 구하고,
    // 각 수가 그 소수로만 이루어졌는지 판단.
    vector<int> che;
    int N, K;
    cin >> N >> K;

    int lim = int(sqrt(N) + 1);
    vector<int> temp(N+1, 0);
    vector<int> primes;
    // 체 만들기.
    for (int i = 2; i <= lim; i++) {
        if(temp[i] == 0) {
            if(i > K) primes.push_back(i);
            for(int j = i; j <= N; j += i) temp[j] = 1;
        }
    }
    for(int i = lim + 1; i <= N; i++) {
        if(temp[i] == 0 && i > K) primes.push_back(i);
    }

    int count = 1;
    for(int num = 2; num <= N; num++) {
        bool pass = true;

        for(vector<int>::iterator it = primes.begin(); it != primes.end(); it++) {
            if(*it > num) break;
            else if( num % *it == 0) {
                pass = false;
                break;
            }
        }

        if(pass) {
            // cout << num << endl;
            count++;
        }
    }
    cout << count;
}