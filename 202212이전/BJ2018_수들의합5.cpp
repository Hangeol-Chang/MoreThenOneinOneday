#include <iostream>
using namespace std;

int main() {
    
    int num;
    cin >> num;

    int l = 1;
    int r = 1;

    int sum = 1;
    int ans = 0;

    while(r <= num){
        if(sum < num) sum += ++r;
        else if(sum > num) sum -= l++;
        else {
            ans++;
            sum -= l++;
            sum += ++r;
        }
        // printf("sum %d\n", sum);
    }
    cout << ans;
}