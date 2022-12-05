#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
    int productCount, companyCount;
    cin >> productCount >> companyCount;

    vector<int> products(productCount);
    vector<int> companies(companyCount);

    for(int i = 0; i < productCount; i++) cin >> products[i];
    for(int i = 0; i < companyCount; i++) cin >> companies[i];

    sort(products.rbegin(), products.rend());
    sort(companies.begin(), companies.end());

    int minCount = min(productCount, companyCount);
    long long ans = 0;
    for(int i = 0; i < minCount; i++) {
        long long cha = products[i] - companies[i];

        if(cha > 0) ans += cha;
        else break;
    }
    cout << ans;
}