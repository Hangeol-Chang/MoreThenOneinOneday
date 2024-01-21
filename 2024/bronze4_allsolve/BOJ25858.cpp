#include <iostream>
#include <vector>

using namespace std;

int main() {
    int student_count, tot_price; cin >> student_count >> tot_price;
    vector<int> students(student_count, 0);
    int tot_solve = 0;
    for(int i = 0; i < student_count; i++) {
        cin >> students[i];
        tot_solve += students[i];
    }

    int money_per_prob = tot_price / tot_solve;
    for(int i = 0; i < student_count; i++) {
        cout << students[i] * money_per_prob << "\n";
    }
}