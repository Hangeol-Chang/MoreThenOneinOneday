#include <iostream> 

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    
    int bundle = 1001; int solo = 1001;
    for(int i = 0; i < M; i++) {
        int a, b; cin >> a >> b;
        
        bundle = a < bundle ? a : bundle;
        solo = b < solo ? b : solo;
    }
    int bundleCount = N / 6;
    int soloCount = N % 6;

    int bundleCost = (bundle < solo*6 ? bundle : solo*6) * bundleCount;
    int soloCost = soloCount*solo < bundle ? soloCount*solo : bundle;

    cout << bundleCost + soloCost;
}