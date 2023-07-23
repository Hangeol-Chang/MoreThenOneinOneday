#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

vector<int> nums;
int N;
int ans = -1;


void calc(vector<int> selected) {
    unordered_map<int, int> parts;

    int sum = 0;
    // for(vector<int>::iterator it = selected.begin(); it != selected.end(); it++)
    //     cout << *it << " ";
    // cout << endl;
    // cout << "sums : ";

    for(vector<int>::iterator it = selected.begin(); it != selected.end(); it++) {
        sum += nums[*it];
        int add = sum % 50;
        // cout << add << " ";

        if(parts.find(add) == parts.end()) {
            parts.insert({add, 1});
        }
        else parts[add] = 2;
    }
    // cout << "\n\n";

    int count = 0;
    for(unordered_map<int, int>::iterator it = parts.begin(); it != parts.end(); it++) 
        if(it->second == 2) 
            count++;
    
    ans = count > ans ? count : ans;
}

void run(int loc, vector<int> selected) {
    if(loc == N) {
        calc(selected);
        return;
    }

    for(int i = 0; i < N; i++)
        // 현재 위치까지만 찾기.
        if(find(selected.begin(), selected.begin() + loc + 1, i) == selected.begin() + loc + 1) {
            selected[loc] = i;
            run(loc + 1, selected);
        }
    
}

int main() {
    cin >> N;
    
    for(int i = 0; i < N; i++) {
        int tmp; cin >> tmp;
        nums.push_back(tmp);
    }

    run(0, vector<int>(N, -1));
    cout << ans;
}