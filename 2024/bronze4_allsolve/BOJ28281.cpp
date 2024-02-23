#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int day, buy; cin >> day >> buy;
    vector<int> costs;

    int prev = 0;
    cin >> prev;
    
    for(int i = 0; i < day-1; i++) {
        int cost; cin >> cost;
        
        costs.push_back(prev + cost);
        prev = cost;
    }
    sort(costs.begin(), costs.end());
    cout << costs[0] * buy;
}