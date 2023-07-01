#include<iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    cout << "Gnomes:\n";
    for(int t = 1; t <= N; t++) {
        int a, b, c;
        cin >> a >> b >> c;
        
        if( (a-b) * (b-c) > 0 ) cout << "Ordered\n";
        else cout << "Unordered\n";
    }
}