#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n; cin >> n;
    double fullLiquid = 0.0;
    for(int i = 0; i < n; i++) {
        double liq; cin >> liq;
        fullLiquid += liq * liq * liq;
    }

    double ans = cbrt(fullLiquid);
    printf("%.10f\n", ans);
}