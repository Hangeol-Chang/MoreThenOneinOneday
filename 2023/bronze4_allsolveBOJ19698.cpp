#include <iostream>

using namespace std;

int main() {
    int N, W, H, L;
    cin >> N >> W >> H >> L;
    
    int w = W / L;
    int h = H / L;
    
    int maxV = w * h;
    cout << min(N, maxV);
}
