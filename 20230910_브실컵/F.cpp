#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;

    long long weight = 0;
    int totApple = 0;

    for(int i = 0; i < N; i++) {
        char idf;
        int W, D, H;
        cin >> idf >> W >> D >> H;

        // 사과박스
        if(idf == 'A') {
            int appleNum = (W/12) * (D/12) * (H/12);
            totApple += appleNum;

            weight += 1000 + appleNum * 500;
        }
        // 배박스
        else weight += 6000;
    }

    cout << weight << "\n" << totApple * 4000;
}