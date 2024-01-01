#include <iostream>
#include <vector>

using namespace std;

// 오른쪽으로 갈 때 idx + 1, 왼쪽으로 갈 때 -1
vector<vector<int>> drdc = {{1, 0}, {0, -1}, {-1, 0}, {1, 0}};

int main() {
    int N; cin >> N;
    string a; cin >> a;

    // 0이면 #, 1이면 .
    vector<vector<int>> map(100, vector<int>(100, 0));

    int minR = 50, minC = 50;
    int maxR = 50, maxC = 50;
    int dr = 1;
    int dc = 0;

    for(char c : a) {

    }
}