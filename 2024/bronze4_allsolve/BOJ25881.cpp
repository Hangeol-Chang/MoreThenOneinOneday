#include <iostream>

using namespace std;

int main() {
    int m, M, N; cin >> m >> M >> N;
    
    for(int n = 1; n <= N; n++) {
        int use; cin >> use;
        int cost = 0;
        if(use > 1000) cost += 1000 * m + (use - 1000) * M;
        else cost = m * use;
        
        cout << use << " " << cost << "\n";
    }
}