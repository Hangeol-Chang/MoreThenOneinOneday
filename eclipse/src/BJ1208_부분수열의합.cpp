#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int nums[40];

int ansdp[2000001] = {-1};

vector<int> set1;
vector<int> set2;

void makeset(int sum, int idx, int limit, vector<int> set) {
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

// 중간에서 만나기 활용.
int main() {
    int target;
    cin >> n >> target;

    for(int i = 0; i < n; i++)
        cin >> nums[i];
    // 입력 끝.

    makeset(0, 0, n/2, set1);
    makeset(0, n/2, n, set2);

    sort(set1.begin(), set1.end());
    sort(set2.begin(), set2.end());

    cout << "set1 " << endl;
    for(int num : set1) cout << num << " ";
    
    cout << "\nset2\n";
    for(int num : set2) cout << num << " ";
    cout << endl;
    // lower, upperbound 가져와서 갯수 세야 함.
}