#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N; cin >> N;
    
    vector<string> map(1, "");
    for(int i = 0; i < N; i++) {
        string inp; cin >> inp;
        map.push_back(inp);
    }

    cin >> N;
    for(int i = 0; i < N; i++) {
        int s, e; cin >> s >> e;

        for(int p = s; p <= e; p++) {
            printf("%s\n", map[p].c_str());
        }
    }
}