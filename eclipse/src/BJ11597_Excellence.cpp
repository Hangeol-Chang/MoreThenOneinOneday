#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int num;
    cin >> num;
    int arr[num];
    for(int i = 0; i < num; i++){
        cin >> arr[i];
    }
    sort(arr, arr + num);

    int hn = num/2;
    int minnum = arr[0] + arr[num-1];
    for(int i = 1; i <hn; i++)
        minnum = min(arr[i] + arr[num-1-i], minnum);

    cout << minnum;
}