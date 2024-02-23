#include <iostream>

using namespace std;

int main() {
    // walk a
    // ele b
    // now k
    // target n

    int n, k, a, b; cin >> n >> k >> a >> b;

    int ele = b * (k-1 + n-1);
    int wal = a * (n-1);

    printf("%d %d", ele, wal);
}