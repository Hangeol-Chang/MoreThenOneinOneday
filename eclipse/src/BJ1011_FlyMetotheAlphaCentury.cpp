#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> vec;

// 나보다 작은 값 중 가장 큰 값 리턴
int lowerbound(int val) {
    int st = 0;
    int ed = vec.size();
    
    while(st < ed) {
        int md = (ed+st)/2;
        // cout << val << "st ed " << st << " " << ed << " md " << md << " " << vec[md] << endl;
        
        if(vec[md] > val) st = md+1;
        else ed = md;
    }
    return ed;
}

int main() {
    int T;
    cin >> T;
    
    // 벡터 만들어놓기.
    long l = 0;
    vec.push_back(0);
    do {
        l++;
        vec.push_back(l + vec[l-1]);
    } while(vec[l] < 1200000000);
    reverse(vec.begin(), vec.end());

    for(int t = 1; t <= T; t++) {
        int st, ed;
        cin >> st >> ed;

        int distance = ed-st;
        // cout << distance/2 << endl;
        int index = lowerbound(distance/2);
        int sdistance = vec[index]*2;

        // cout << (vec.size() - index - 1) << endl;
        int ans = (vec.size() - index - 1)*2;
        // cout << "index : " << index << " val " << vec[index] << " dis, sdis " << distance << " " << sdistance << endl;

        int idf = distance - sdistance;
        if(idf > (vec.size() - index)) ans += 2;
        else if (idf > 0) ans++;

        cout << ans << endl;
    }   
}
/*

7
0 4
0 6
0 7
0 9
0 12
0 14
0 15

3
4
5
5
6
7
7

*/