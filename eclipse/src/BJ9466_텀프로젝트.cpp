/*
사이클이 만들어 졌을 때, 시작 위치인지 보면 됨.

*/

#include <iostream>

using namespace std;

int choose[100001];
int p[100001];
int solocount;

// 서로소 집합 활용
int parent(int x) {
    if(p[x] == x) return x;
    else return p[x] = parent(p[x]);
}

void join(int x, int y) {
    p[parent(y)] = parent(x);
    return;
}

int rot(int now) {
    // union하고, cycle이 만들어졌는지 판단.
    
    int ch = choose[now];
    choose[now] = 0;

    if(ch == 0) {
        p[now] = now;
        return -1;
    }

    if(parent(now) == parent(ch)) {
        // cout << now << " " << parent(now) << " " << parent(ch) << endl;

        solocount--;
        if(now != ch) return ch;
        else          return -1;
    }

    join(now, ch);
    int ret = rot(ch);

    if(ret != -1) {
        solocount--;

        if(now == ret) return -1;
        else           return ret;
    }
    else {
        // 부모 원래대로 돌려놓기.
        p[now] = now;
        return -1;
    }
}

int main() {
    int T;
    cin >> T;

    // 테스트케이스 반복
    for(int t = 1; t <= T; t++) {
        int n;
        cin >> n;

        for(int i = 1; i <= n; i++){
            cin >> choose[i];
            p[i] = i;
        }
        // 입력받기 끝.
        
        solocount = n;
        for(int i = 1; i <= n; i++) {
            if(choose[i] != 0)
                rot(i);
            
            // for(int j = 1; j <= n; j++) {
            //     cout << choose[j] << " ";
            // }
            // cout << "solocount : " << solocount << endl;

            // for(int j = 1; j <= n; j++) {
            //     cout << p[j] << " ";
            // }
            // cout << "p`s\n" << endl;
        }
        cout << solocount << endl;
    }
}

/*

7
6
2 3 4 5 6 2
5
2 5 4 5 2
6
1 3 4 3 2 6
13
2 4 5 2 4 1 8 9 10 11 9 10 10
10
2 5 7 1 6 8 8 3 5 10
10
2 7 10 5 3 3 9 10 6 3
6
2 1 1 2 6 3

1
3
2
8
6
8
4


*/