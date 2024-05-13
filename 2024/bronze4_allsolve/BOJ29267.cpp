#include <iostream>

using namespace std;

int main() {
    int N, K; cin >> N >> K;

    int bullet = 0;
    int saveBullet = 0;
    for(int n = 0; n < N; n++) {
        string order; cin >> order;

        if(order == "save") saveBullet = bullet;
        else if (order == "load") bullet = saveBullet;
        else if (order == "shoot") {
            --bullet;
            if(bullet < 0) bullet = 0;
        }
        else bullet += K;


        cout << bullet << "\n";
    }
}