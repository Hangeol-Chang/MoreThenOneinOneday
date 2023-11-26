#include <iostream>

using namespace std;

int main() {
    // 86400
    int h1, m1, s1;
    int h2, m2, s2;
    char j;
    cin >> h1 >> j >> m1 >> j >> s1;
    cin >> h2 >> j >> m2 >> j >> s2;

    int secT1 = h1 * 3600 + m1 * 60 + s1;
    int secT2 = h2 * 3600 + m2 * 60 + s2;
    
    int totTime = secT2 - secT1;
    if(totTime < 0) totTime += 86400;

    cout << totTime;
}