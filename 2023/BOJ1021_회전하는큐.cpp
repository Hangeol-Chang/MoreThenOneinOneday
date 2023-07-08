#include <iostream>
#include <deque>
#include <vector>

using namespace std;

int main() {
    int n, C;
    cin >> n >> C;
    
    deque<int> dq(n);
    for(int i = 1; i <= n; i++) dq[i-1] = i;

    int action = 0;

    for(int c = 0; c < C; c++) {
        int num;
        cin >> num;

        if(dq[0] == num) {
            dq.pop_front();
            continue;
        }

        int front = 1;
        int back  = 1;

        // 앞에서부터 찾아보고, 뒤에서부터 찾아서, 빠른걸로 하기
        for(deque<int>::iterator it = dq.begin() + 1; it != dq.end(); it++) {
            if(*it == num) break;
            front++;
        }
        for(deque<int>::reverse_iterator it = dq.rbegin(); it != dq.rend() - 1; it++) {
            if(back > front) break;
            if(*it == num) break;
            back++;
        }

        if(front <= back) {
            while(front-- > 0) {
                action++;
                dq.push_back(dq.front());
                dq.pop_front();
            }
        }
        else {
            while(back-- > 0) {
                action++;
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
        dq.pop_front();

        // for(deque<int>::iterator it = dq.begin(); it != dq.end(); it++) {
        //     cout << *it << " ";
        // }
        // cout << endl;
        // cout << "action : " << action << endl;
    }
    cout << action;
}