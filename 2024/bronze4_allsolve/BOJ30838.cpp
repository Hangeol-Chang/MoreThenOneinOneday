#include <iostream>

using namespace std;

int main() {
    int N; cin >> N;

    for(int n = 0; n < N; n++) {
        int vote; cin >> vote;

        while(vote > 0) {
            if(vote >= 5) {
                vote -= 5;
                cout << "++++ ";
            }
            else {
                vote -= 1;
                cout << "|";
            }
        }
        cout << "\n";
    }
}