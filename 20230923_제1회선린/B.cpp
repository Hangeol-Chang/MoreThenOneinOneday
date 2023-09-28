#include <iostream>

using namespace std;

int GetGrade(int num) {
    if(num > 96.0)     return 9;
    else if (num > 89) return 8;
    else if (num > 77) return 7;
    else if (num > 60) return 6;
    else if (num > 40) return 5;
    else if (num > 23) return 4;
    else if (num > 11) return 3;
    else if (num > 4)  return 2;
    else return 1;
}

int main() {
    int N, K; cin >> N >> K;

    for(int i = 0; i < K; i++) {
        int sc; cin >> sc;

        cout << GetGrade(sc * 100 / N) << " ";
    }   
}