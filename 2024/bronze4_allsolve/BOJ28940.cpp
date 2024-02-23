#include <iostream>

using namespace std;

int main() {
    int w, h; cin >> w >> h;

    int letterCount, letterW, letterH;
    cin >> letterCount >> letterW >> letterH;

    int pageLetterCount = (w/letterW) * (h/letterH);

    if(pageLetterCount == 0) cout << -1;
    else {
        int ans = letterCount / pageLetterCount;
        if(letterCount % pageLetterCount != 0) ans += 1;
        cout << ans;
    }
}