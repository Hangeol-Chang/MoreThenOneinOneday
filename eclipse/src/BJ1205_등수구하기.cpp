#include<iostream>
#include<vector>

using namespace std;

vector<int> scores;

int upperbound(int score) {
    int st = 0;;  
    int ed = scores.size();

    while(st < ed) {
        int md = (st + ed) / 2;
        
        if(scores[md] >= score) st = md;
        else                    ed = md - 1;
    }  
    return ed;
}

int main() {
    int n, score, p;
    cin >> n >> score >> p;

    for(int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        scores.push_back(tmp);
    }
    scores.push_back(-1);
    
    int now = scores[0];
    int rank = 1;
    int loc = 0;
    for(int i = 0; i < n+1; i++) {
        // cout << "now : " << now << ", rank : " << rank << endl;

        if(score > scores[i]) {
            loc = i + 1;
            if(i >= 1 && score != scores[i-1]){
                rank = i+1;
            }
            break;
        }
        if(now > scores[i]) {
            rank = i + 1;
            now = scores[i];
        }
    }   
    // cout << loc << endl;
    if(loc <= p) cout << rank;
    else cout << -1;
}