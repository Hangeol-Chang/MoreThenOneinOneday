#include <iostream>

int main() {
    int s, e; std::cin >> s >> e;
    int ans = 0;
    if(s > 19) ans = 24 - s + e;
    else ans = e - s;

    std::cout << ans;
}