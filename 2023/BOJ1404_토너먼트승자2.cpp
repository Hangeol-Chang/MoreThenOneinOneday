#include <iostream>
#include <vector>

using namespace std;

vector<vector<double>> map(8, vector<double>(8, 0));

int pow(int a, int b) {
    int ret = 1;
    while(b-- > 0) 
        ret *= a;

    return ret;
}

vector<double> fight(vector<double> bef, int round) {
    int ite = pow(2, round);
    vector<double> ret(8, 0);

    for(int i = 0; i < 8; i++) {
        int idf = i / ite;

        int t = (idf * ite) + (idf % 2 == 0 ? ite : -ite); 
        for(int j = t; j < t+ite; j++)
            ret[i] += map[i][j] * bef[i] * bef[j];
    }
    return ret;
}

int main() {

    for(int i = 0; i < 7; i++) {
        for(int j = i + 1; j < 8; j++) {
            int tmp; cin >> tmp;
            double per = tmp / 100.0;
            map[i][j] = per;
            map[j][i] = 1 - per;
        }
    }   

    // 입력 완료.
    vector<vector<double>> calc(4, vector<double>(8, 1));
    for(int i = 0; i < 3; i++) {
        calc[i + 1] = fight(calc[i], i);
    }

    for(vector<double>::iterator it = calc[3].begin(); it != calc[3].end(); it++) 
        printf("%11.10f ", *it);
}