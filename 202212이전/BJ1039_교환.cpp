#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;

// 남은 최소치를 저장하는게 맞을까?
/*
짝수번 남았을 때 max판단 해도 됨.
이렇게 할거면, 이미 있는 수를 만났을 떄 거르면 됨.

변경수가 0으로 주어지는 경우 없음.

*/

struct node {
    int data = 0;
    int left = 0;

    node() {};
    node(int datain, int leftin) : data(datain), left(leftin) {};
};

int main() {
    // 남은 수를 저장.
    vector<int> nodes(1000001);
    
    int num, left;
    cin >> num >> left;
    
    string numString = to_string(num);
    // 뒤에 0밖에 없는지 판단.
    for(int i = 1; i < numString.length(); i++) {
        char chr = numString[i];
        if( chr != '0' ) goto pass;
    }
    // 여기 도착하면 0밖에 없는 것. 한자리도 여기에 걸림.
    cout << -1;
    return 0;
    
    // 바꾸는게 가능하면 계산 시작.
    pass:
    //////////////////////////////////////
    int maxval = -1;
    queue<node> que;
    que.push(node(num, left));

    while(!que.empty()) {
        node now = que.front();
        que.pop();

    }

    cout << maxval;
}