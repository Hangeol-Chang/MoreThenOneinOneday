#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    int arr[n];
    int sum2 = 0;
    // 두 탑의 거리의 최댓값.
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        sum2 += arr[i];
    }

    int l = 0;
    int r = 1;
    int sum1 = arr[0];
    sum2 -= sum1;

    int ans = min(sum1, sum2);
    while(r < n) {
        // cout << "sum1 : " << sum1 << ", sum2 : " << sum2 << ", l r : " << l << " " << r << endl;
        // sum1을 올리기
        if(sum1 == sum2) {
            cout << sum1;
            return 0;
        }
        if( sum1 < sum2 || l == r) {
            sum1 += arr[r];
            sum2 -= arr[r];
            r++;
        }
        // sum2를 올리기(l 증가)
        else {
            sum1 -= arr[l];
            sum2 += arr[l];
            l++;
        }
        
        // 최댓값 넣기.
        ans = max(ans, min(sum1, sum2));
    }
    cout << ans;
}

/*

5
1
1
30
1
1

10
1
4
5
9
55
444
1
4
7
6

*/