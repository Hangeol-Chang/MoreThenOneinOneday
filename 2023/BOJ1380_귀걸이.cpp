#include <iostream>
#include <vector>

using namespace std;

int main() {
    int sina = 1;

    while(1) {
        int n;
        cin >> n;
        if (n == 0) break;
        cin.ignore();

        vector<string> students;
        for(int i = 1; i <= n; i++) {
            string tmpname;
            getline(cin, tmpname);
            students.push_back(tmpname);
        }

        int cash = 0;
        for(int i = 1; i <= n; i++) cash += i * 2;

        n = 2 * n - 1;
        for(int i = 1; i <= n; i++) {
            int idx;
            char c;
            cin >> idx >> c;
            
            cash -= idx;
        }
        cout << sina++ << " " << students[cash - 1] << "\n";
    }
}