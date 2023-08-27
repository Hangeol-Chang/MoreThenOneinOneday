#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    int h = 2;
    int w = N - (h-1);

    int ans = N;

    while(h < w) {
        int newans = h * w;
        ans = newans > ans ? newans : ans;

        cout << h << " " << w << " " << ans << endl;
        w -= h;
        h += 1;
    }
      
    cout << ans;
}