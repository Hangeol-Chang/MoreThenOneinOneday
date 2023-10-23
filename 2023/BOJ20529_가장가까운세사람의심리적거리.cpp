#include <iostream>
#include <vector>

using namespace std;

vector<int> ps;

int calcbit(int a, int b) {
    // cout << "ab : " << a << " " << b << " || ";
    int ret = 0;
    for(int x = 0; x < 4; x++) {
        int num1 = a & (1 << x);
        int num2 = b & (1 << x);
        // cout << num1 << " " << num2 << " | ";
        if(num1 != num2) ++ret;
    }
    // cout << ret << endl;
    return ret;
}

int ans = 99;
void makeans(vector<int> selected) {
    int newans = 0;
    newans += calcbit(selected[0], selected[1]);
    newans += calcbit(selected[1], selected[2]);
    newans += calcbit(selected[2], selected[0]);
    
    ans = ans < newans ? ans : newans;
    return;
}

void run(vector<int> selected, int sel, int idx) {
    if(sel == 3) {
        makeans(selected);
        return;
    }

    for(int i = idx; i < 16; i++) {
        if(ps[i] > 0) {
            selected[sel] = i;
            --ps[i];
            run(selected, sel + 1, i);
            ++ps[i];
        }
    }
}

int main() {
    int T; cin >> T;
    
    // 비트마스킹
    for(int t = 0; t < T; t++) {
        ans = 99;
        ps = vector<int>(16, 0);

        int N; cin >> N;
        string tmp;
        for(int n = 0; n < N; n++) {
            cin >> tmp;
            
            // EI || SN || FT || JP
            int num = 0;
            if(tmp[0] == 'I') num = num | 1 << 3;
            if(tmp[1] == 'N') num = num | 1 << 2;
            if(tmp[2] == 'T') num = num | 1 << 1;
            if(tmp[3] == 'P') num = num | 1 << 0;

            ps[num] += 1;
        }
        // 입력 처리 완료
        
        if(N > 32) {
            cout << "0\n";
        }
        else {
            run(vector<int>(3, 0), 0, 0);
            cout << ans << "\n";
        }
    }
}