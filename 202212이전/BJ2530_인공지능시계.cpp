#include<iostream>

using namespace std;

int main() {
    int h, m, s;
    cin >> h >> m >> s;
    int d;
    cin >> d;
    
    s += d;
    if(s >= 60) {
        m += s/60;
        s = s%60;
    }
    if(m >= 60) {
        h += m/60;
        m = m%60;
    }
    h = h%24;
    
    cout << h << " " << m << " " << s;
}
