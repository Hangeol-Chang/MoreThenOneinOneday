#include<iostream>

using namespace std;

int main() {
    int totcost;
    cin >> totcost;

    int n;
    cin >> n;

    int sumcost = 0;
    for(int i = 0; i < n; i++) {
        int cost, count;
        cin >> cost >> count;

        sumcost += cost * count;
    }
    if(sumcost == totcost) cout << "Yes";
    else cout << "No";
}