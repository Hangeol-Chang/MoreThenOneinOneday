#include<iostream>

using namespace std;

int main() {
    int n; cin >> n;

    int arr[n];
    int count[1001];
    fill_n(count, 1001, 0);

    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        count[arr[i]]++;
    }
    // 누적합으로 만들기.
    for(int i = 1; i < 1001; i++) {
        count[i] += count[i-1];
    }

    // 역순으로 배열
    int ans[n];
    for(int i = n-1; i >= 0; i--) {
        ans[i] = --count[arr[i]];
    }
    for(int num : ans) cout << num << " ";
}