#include <iostream>
#include <vector>

using namespace std;

vector<vector<double>> map(8, vector<double>(8, 0));

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

    // debug 1
    // for(int i = 0; i < 8; i++) {
    //     for(int j = 0; j < 8; j++) {
    //        printf("%4.2f ", map[i][j]);
    //     }
    //     cout << endl;
    // }
    // cout << endl;

    // make sec
    vector<double> sec(8, 0);
    for(int i = 0; i < 8; i++) {
        int j = i % 2 == 0 ? i + 1 : i - 1;
        sec[i] = map[i][j];
    }
    
    // debug 2
    // for(vector<double>::iterator it = sec.begin(); it != sec.end(); ++it) {
    //     cout << *it << " ";
    // }
    // cout << endl;

    // make thr
    vector<double> thr(8, 0);
    // 내가 올라올 확률 * 쟤가 올라올 확률 * 내가 이길 확률
    // 1 - 34, 2 - 34, 3 - 12, 4 - 12 | 5 - 78, 6 - 78, 7 - 56
    // 0               1                2               3
    for(int i = 0; i < 8; i++) {
        int idf = i / 2;
        int t = (idf * 2) + (idf % 2 == 0 ? 2 : -2);

        for(int j = t; j < t+2; j++)
            thr[i] += map[i][j] * sec[i] * sec[j];
    }

    // debug 3
    // for(vector<double>::iterator it = thr.begin(); it != thr.end(); ++it) {
    //     cout << *it << " ";
    // }
    // cout << endl;

    vector<double> fin(8, 0);
    for(int i = 0; i < 8; ++i) {
        int idf = i / 4;
        int t = (idf * 4) + (idf % 2 == 0 ? 4 : -4);
        
        // cout << idf << " " << t << endl;

        for(int j = t; j < t+4; j++)
            fin[i] += map[i][j] * thr[i] * thr[j];
    }

    // for(vector<double>::iterator it = fin.begin(); it != fin.end(); ++it) {
    //     cout << *it << " ";
    // }
    // cout << endl;
    for(vector<double>::iterator it = fin.begin(); it != fin.end(); it++) 
        printf("%11.10f ", *it);
}