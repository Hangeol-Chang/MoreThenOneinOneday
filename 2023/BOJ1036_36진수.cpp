#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> map(53, vector<int>(0));

struct node {
    int num;
    vector<int> weight;
    
    node(int n, vector<int> w) : num(n), weight(w) {};
};
// weight 순으로 정리.
bool nodeCmp(node a, node b) {
    int size = a.weight.size();

    for(int i = size - 1; i >= 0; i--) {
        if(b.weight[i] != a.weight[i])
            return b.weight[i] < a.weight[i];
    }
    return 0;
}

int main() {
    int N; cin >> N;

    int strlen = 0;
    vector<bool> appear(36, false);

    for(int i = 1; i <= N; i++) {
        string inp;
        cin >> inp;

        strlen = inp.size() > strlen ? inp.size() : strlen;

        int j = 0;
        for(auto it = inp.rbegin(); it != inp.rend(); it++) {
            int tmpnum = 0;
            if(*it < 'A') tmpnum = *it - '0';
            else          tmpnum = *it - 'A' + 10;

            map[j].push_back(tmpnum);
            appear[tmpnum] = true;
            ++j;
        }
    }

    int K; cin >> K;
    
    // sorting은 아무 의미가 없음.
    // for(vector<vector<int>>::iterator it = map.begin(); it != map.begin() + strlen; it++) 
    //     sort(it->begin(), it->end());
    
    // 입력 정리 완료.

    vector<node> gains;

    for(int k = 0; k < 36; k++) {
        if(!appear[k]) continue;
        // *it를 35로 바꿀 때, gain 양을 작성.

        vector<int> weight(strlen + 3, 0);

        for(int i = 0; i < strlen; i ++) {
            int nowgain = 0;
            for(auto num = map[i].begin(); num != map[i].end(); num++) {
                // 바꿀 숫자라면 gain 계산.
                if(*num == k) 
                    nowgain += 35 - *num;
            }
            nowgain += weight[i];

            weight[i+1] += nowgain / 36;
            weight[i] = nowgain % 36;
        }
        gains.push_back(node(k, weight));
    }
    // weight가 높은 순으로 정리.
    sort(gains.begin(), gains.end(), nodeCmp);

    // K개의 숫자를 35로 변경
    vector<int> changeNum(36, 0);
    for(int i = 0; i < 36; i++) changeNum[i] = i;

    K = K < gains.size() ? K : gains.size();
    for(int i = 0; i < K; i++) {
        // cout << gains[i].num << " " << (char)(gains[i].num - 10 + 'A') << endl;
        changeNum[gains[i].num] = 35;
    }

    // for(vector<vector<int>>::iterator it = map.begin() + strlen - 1; it != map.begin() - 1; it--) {
    //     for(vector<int>::iterator it2 = it->begin(); it2 != it->end(); it2++) {
    //         if(K <= 0) goto outer;

    //         if(changeNum[*it2] != 35) {
    //             changeNum[*it2] = 35;
    //             --K;
    //         }
    //     }
    // }
    outer:;
    // 합치기
    vector<int> sum(0);

    for(vector<vector<int>>::iterator it = map.begin(); it != map.end(); it++) {
        if(it->size() == 0) break;
        int nowsum = 0;

        for(vector<int>::iterator it2 = it->begin(); it2 != it->end(); it2++) 
            nowsum += changeNum[*it2];
        
        // cout << nowsum << " " << nowsum / 36 << endl;        
        sum.push_back(nowsum);
    }

    // 맨 앞에 1의 자리가 들어있음.
    for(int i = 0; i < sum.size(); i++) {
        if(sum[i] >= 36) {

            if(i+1 < sum.size()) sum[i+1] += sum[i] / 36;
            else                 sum.push_back(sum[i] / 36);            
            sum[i] %= 36;
        }
    }

    for(auto it = sum.rbegin(); it != sum.rend();  it++) {
        if(*it < 10) cout << *it;
        else         cout << (char)(*it - 10 + 'A');
    }
}