#include <iostream>

using namespace std;

int main() {
    int s, e; cin >> s >> e;

    while(s <= e) {
        cout << "All positions change in year " << s << "\n";
        s += 60;
    }
}