#include <iostream>
#include <vector>

using namespace std;

int main() {
    int K, M;
    cin >> K;
    cin >> M;

    vector<int> peo;
    for(int i = 0; i <= K; i++) peo.push_back(i);

    for(int i = 1; i <= M; i++) {
        int r;
        cin >> r;

        vector<int> tmpPeo;
        tmpPeo.push_back(0);

        int len = peo.size();
        for (int j = 1; j < len; j++) {
            if( j % r == 0 ) continue;
            tmpPeo.push_back(peo[j]);
        }


        peo = tmpPeo;
    }

    int len = peo.size();
    for(int i = 1; i < len; i++) cout << peo[i] << "\n";
}