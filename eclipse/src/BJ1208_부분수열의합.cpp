#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int nums[40];


vector<int> set1;
vector<int> set2;

void makeset(int sum, int idx, int limit, vector<int> &set) {
    if(idx >= limit) return;
    // 부분집합 만드는 코드.
    // 나를 선택하지 않은 다음 함수 호출.
    makeset(sum, idx+1, limit, set);

    // 나를 선택하고, 그 값을 set에 넣음.
    sum += nums[idx];
    set.push_back(sum);
    makeset(sum, idx+1, limit, set);
    // 나를 선택한 다음 함수 실행.
}

int lowerbound(int target) {
    int st = 0;
    int ed = set2.size();
    while(st < ed) {
        int md = (st + ed)/2;

        if(set2[md] < target) st = md+1;
        else ed = md;
    }
    return st;
}

int upperbound( int target) {
    int st = 0;
    int ed = set2.size();
    while(st < ed) {
        int md = (st + ed)/2;

        if(set2[md] <= target) st = md+1;
        else ed = md;
    }
    return ed;
}

// 중간에서 만나기 활용.
int main() {
    int target;
    cin >> n >> target;

    for(int i = 0; i < n; i++)
        cin >> nums[i];
    // 입력 끝.

    // cout << 0 << "to" << n/2 << ", " << n/2 << "to" << n << endl;
    makeset(0, 0, n/2, set1);
    makeset(0, n/2, n, set2);

    // sort(set1.begin(), set1.end());
    sort(set2.begin(), set2.end());

    // cout << "set1 " << set1.size() << endl;
    // for(int num : set1) cout << num << " ";
    // cout << "\nset2 " << set2.size() << endl;
    // for(int num : set2) cout << num << " ";
    // cout << "\n\n";

    // set1을 돌면서 만들기.
    long long ans = 0;

    for(int num : set1) {
        int low = lowerbound(target - num);
        int upp = upperbound(target - num);
        
        // cout << num << ", low, upp : " << low << " " << upp << endl;
        ans += upp - low;
    }

    for(int num : set1) if(num == target) ans++;
    for(int num : set2) if(num == target) ans++;
    cout << ans << endl;
    // lower, upperbound 가져와서 갯수 세야 함.
}

/*

11 0
-20 -17 -13 -5 1 5 7 9 10 11 17

40 0
-40 -320 -10 -74 -20 -17 -13 -5 1 5 7 9 10 11 17 -40 -320 -10 -74 -20 -17 -13 -5 1 5 7 9 10 11 17 -40 -320 -10 -74 -20 -17 -13 -5 1 5

*/