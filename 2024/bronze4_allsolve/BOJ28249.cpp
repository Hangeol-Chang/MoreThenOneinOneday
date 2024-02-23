#include <iostream>
#include <unordered_map>

#define si pair<string, int>

using namespace std;

int main() {
    unordered_map<string, int> map;
    map.insert(si("Poblano", 1500));
    map.insert(si("Mirasol", 6000));
    map.insert(si("Serrano", 15500));
    map.insert(si("Cayenne", 40000));
    map.insert(si("Thai", 75000));
    map.insert(si("Habanero", 125000));

    int N; cin >> N;
    
    int ans = 0;
    for(int n = 1; n <= N; n++) {
        string key;
        cin >> key;
        auto a = map.find(key);
        ans += a->second;
    }
    cout << ans;
}