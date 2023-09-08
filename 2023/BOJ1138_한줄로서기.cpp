#include <iostream>
#include <vector>

using namespace std;

struct p {
    int left;
    int idx;
    
    p(int l, int i) : left(l), idx(i) {}
};

int main() {
    int N;
    cin >> N;
    
    vector<p> people;

    for(int i = 0; i < N; i++) {
        int tmp;
        cin >> tmp;
        people.push_back(p(tmp, i+1));    
    }

    vector<int> ans;
    while(!people.empty()) {
        
        for(vector<p>::iterator it = people.begin(); it != people.end(); it++) {
            if(it->left > 0) continue;
            // 0인 것을 만나면

            // 이전껏까지 지우기.
            for(vector<p>::iterator it2 = people.begin(); it2 != it; it2++)
                it2->left -= 1;

            ans.push_back(it->idx);
            people.erase(it);
            goto outer;
        }
        outer:;
    }

    for(vector<int>::iterator it = ans.begin(); it != ans.end(); it++)
        cout << *it << " ";
}