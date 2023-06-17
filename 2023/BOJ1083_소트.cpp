#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 역순 정렬
int main() {
    int N, M;

    cin >> N;
    vector<int> nums(N, 0);
    for(int i = 0; i < N; i++) cin >> nums[i];
    cin >> M;


    // point번째 수를 가능한 최대로 만들고, 그 다음으로 넘어가는 방법.
    int point = 0;
    while(M > 0 && point < nums.size()) {
        // cout << "point : " << point << endl;

        int maxidx = point;
        int maxval = nums[point];
        int endpoint = min(N-1, point + M);

        for(int i = point + 1; i <= endpoint; i++) {
            if(maxval < nums[i]) {
                maxidx = i;
                maxval = nums[i];
            } 
        }

        // 이만큼 움직일거임.
        nums.erase(nums.begin() + maxidx);
        nums.insert(nums.begin() + point, maxval);

        // for(vector<int>::iterator it = nums.begin(); it != nums.end(); it++) cout << *it << " ";
        // cout << endl;
        M -= (maxidx - point);
        // cout << "cost : " << maxidx - point << " | remain : " << M << endl << endl;
        
        point++;
    }
    for(vector<int>::iterator it = nums.begin(); it != nums.end(); it++) cout << *it << " ";
    
}