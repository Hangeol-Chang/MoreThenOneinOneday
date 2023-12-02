#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<long long> sharks;

int main() {
    // 상어 마릿수, 먹을 수 있는 최대 마릿수, 샼의 최초 크기.
    int N, K;
    long long T;
    cin >> N >> K >> T;
    
    for(int n = 0; n < N; n++) {
        long long tmp;
        cin >> tmp;
        sharks.push_back(tmp);
    }
    sort(sharks.begin(), sharks.end());
    int pointer = 0;
    
    while(K-- > 0) {
        while(pointer < sharks.size() - 1 && sharks[pointer] < T) pointer++;
        while(pointer >= 0 && sharks[pointer] >= T) pointer--;

        if(pointer < 0) break;

        // cout << pointer << "\n";

        T += sharks[pointer];
        sharks.erase(sharks.begin() + pointer);
        if(pointer >= sharks.size() -1) pointer = sharks.size() - 1;
        // for(auto it = sharks.begin(); it != sharks.end(); it++) cout << *it << " ";

        // cout << "\n";
    }


    cout << T;
}