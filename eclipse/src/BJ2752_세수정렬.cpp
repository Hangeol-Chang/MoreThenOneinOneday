#include<iostream>
#include<queue>
#include<vector>

using namespace std;

struct cmp {
    bool operator()(int a, int b) {
        return a > b;
    }
};

int main() {
    priority_queue<int, vector<int>, cmp> pq;
    
    for(int i = 0; i < 3; i++) {
        int tmp;
        cin >> tmp;
        pq.push(tmp);
    }

    while(!pq.empty()) {
        cout << pq.top() << " ";
        pq.pop();
    }
}