#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

/*
합이 최소가 되게 할 것.
1, 2, 3면이 노출되는 주사위수를 체크.

5면 : N이 1일 때 1

1면 : N이 3보다 클 때 (N-2)^2 * 5
2면 : N이 2보다 클 때 (N-1)*4 + (N-2)*4

3면 : N이 2보다 클 때 4개

A B C D E F
0 1 2 3 4 5

2면
AB AC AD AE FB FC FD FE + 3면꺼 네개

3면
BC CE DE BD
12 24 34 13 + 0 or 5

*/
int indexer2[12][2] = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {1, 2}, {2, 4}, {3, 4}, {1, 3}};
int indexer3[4][2] = {{1, 2}, {2, 4}, {3, 4}, {1, 3}};

long long ans = 0;
int main() {
    long long N;
    cin >> N;

    vector<int> dice(6);
    for(int i = 0; i < 6; i++) cin >> dice[i];
    // 입력 완료.
    
    if(N == 1) {
        // 오름차순으로 정렬하고 최댓값 빼고 다더하기.
        sort(dice.begin(), dice.end());
        for(int i = 0; i < 5; i++) ans += dice[i];

    } else {
        // N이 2보다 크거나 같은 경우

        // 2면이 보이는 것들.
        int min2 = 100;
        int count2 = (N-1)*4 + (N-2)*4;
        for(int *num : indexer2)
            min2 = min(min2, dice[num[0]] + dice[num[1]]);

        // 3면이 보이는 것들
        int min3 = 150;
        int count3 = 4;
        int indexer3_2[2] = {0, 5};
        for(int *num : indexer3) {
            int addtwo = dice[num[0]] + dice[num[1]];

            for(int third : indexer3_2)
                min3 = min(min3, addtwo + dice[third]);
        }

        int min1 = 50;
        long long count1 = 0;
        // N이 3보다 크거나 같을 때.
        if( N > 2) {
            for(int num : dice) min1 = min(min1, num);
            count1 = (N-2)*(N-2) * 5 + (N-2)*4;
        }
        
        ans = min1*count1 + min2*count2 + min3*count3;

        // cout << "min1 : " << min1 << ", count1 : " << count1 << "\n"; 
        // cout << "min2 : " << min2 << ", count2 : " << count2 << "\n"; 
        // cout << "min3 : " << min3 << ", count3 : " << count3 << "\n"; 
    }
    cout << ans;
}