#include <iostream>
#include <algorithm>

using namespace std;

int counts[2];
int len;

string ini;
string ans = string(50, 'z');

void set(int i1, int i2) {
    string s1 = ini.substr(0, i1);
    string s2 = ini.substr(i1, i2);
    string s3 = ini.substr(i1+i2, 50);

    // cout << s1 << " " << s2 << " " << s3 << "\n";
    
    reverse(s1.begin(), s1.end());
    reverse(s2.begin(), s2.end());
    reverse(s3.begin(), s3.end());

    string tmp = s1 + s2 + s3;
    if(ans > tmp) {
        ans = tmp;
    }
}

void divide(int selected, int idx) {
    if(selected == 2) {
        set(counts[0], counts[1]);
        return;
    }

    for(int i = idx; i < len-1; i++) {
        counts[selected] = i - idx + 1;
        divide(selected + 1, i + 1);
    }
}

int main() {
    cin >> ini;
    len = ini.length();

    divide(0, 0);

    cout << ans;
    return 0;
}
