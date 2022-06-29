#include <iostream>

using namespace std;

int nums[201];

int main() {
    int N;
    cin >> N;

    for(int i = 0; i < N; i++){
        int tmp;
        cin >> tmp;
        nums[tmp + 100]++;
    }

    int ans;
    cin >> ans;
    cout << nums[ans + 100] << endl;
}