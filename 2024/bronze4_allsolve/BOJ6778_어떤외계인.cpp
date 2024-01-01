#include <iostream>
#include <vector>

using namespace std;

int main() {
    int a; int e;
    cin >> a >> e;
    vector<string> ans;

    if(a >= 3 && e <= 4) ans.push_back("TroyMartian"); // 화성인
    if(a <= 6 && e >= 2) ans.push_back("VladSaturnian"); // 토성인
    if(a <= 2 && e <= 3) ans.push_back("GraemeMercurian"); // 수성인

    for(auto it = ans.begin(); it != ans.end(); it++) cout << *it << "\n";   
}