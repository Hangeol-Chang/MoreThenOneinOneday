#include<iostream>

using namespace std;

int main() {
    for(int T = 0; T < 3; T++) {
        int h1, m1, s1, h2, m2, s2;
        cin >> h1 >> m1 >> s1 >> h2 >> m2 >> s2;

        int ah = h2 - h1;
        int am = m2 - m1;
        int as = s2 - s1;

        if(as < 0) {
            as += 60;
            am -= 1;
        }
        if(am < 0) {
            am += 60;
            ah  -= 1;
        }
        cout << ah << " " << am << " " << as << endl;
    }
}