#include <iostream>
#include <set>

using namespace std;

int main() {
    int N; cin >> N;

    set<long long> map;
    for(int i = 0; i < N; ++i) {
        long long tmp; cin >> tmp;
        map.insert(tmp);
    }


    long long ans = *(map.rbegin()) - *(map.begin());
    
    long long endvalue = *(map.rbegin());
    long long compvalue = 0;

    while(endvalue != compvalue) {

        compvalue = *map.begin();

        map.erase(compvalue);
        map.insert(compvalue*2);

        // for(set<long long>::iterator it = map.begin(); it != map.end(); it++) {
        //     cout << *it << " ";
        // }
        
        long long ansCand = *(map.rbegin()) - *(map.begin());
        ans = min(ans, ansCand);
        // cout << " || " << ans << endl;
    }

    cout << ans;
}