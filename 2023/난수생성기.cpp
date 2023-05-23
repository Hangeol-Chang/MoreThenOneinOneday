#include <random>
#include <iostream>
#include <set>

using namespace std;

int main() {
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<int> dis1000(0, 1000);
    std::uniform_int_distribution<int> dis100(0, 100);

    for(int t = 0; t < 3; t++) {
        // int n = dis1000(gen);
        int n = 1000;
        // int zari = dis100(gen);
        int zari = 100;
        
        cout << n << endl;
        
        // cout << zari;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < zari; j++) {
                cout << rand() % 10;
            }
            cout << endl;
        }
    
    cout << "\n==================\n";
    }
}