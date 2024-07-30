#include <iostream>
#include <string>
#include <map>
#include <vector>

using namespace std;

int main() {
    int n; cin >> n;

    // map<int, vector<string>> courses;

    // for (int i = 0; i < n; i++) {
        int d; cin >> d;
        
        vector<string> foods(d);
        for(int i = 0 ; i < d; i++) { cin >> foods[i]; }
        // courses.insert({d, foods});
    // }

    cout << d << "\n";
    for(auto f : foods) { cout << f << "\n"; }
}