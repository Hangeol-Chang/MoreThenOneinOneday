#include <iostream>
#include <vector>

using namespace std;

// vector<int> sort(vector<int> arr) {
//     int N = arr.size();

//     for (int i = N - 1; i > 0; i--) {
//         for (int j = i - 1; j >= 0; j--) {
//             if (arr[j] > arr[j + 1]) {
//                 int tmp = arr[j];
//                 arr[j] = arr[j + 1];
//                 arr[j + 1] = tmp;
//             }
//         }
//     }

//     return arr;
// }

int main() {
    int N; cin >> N;
    vector<int> arr;

    while(N >= 3) {
        arr.push_back(N--);
    }
    arr.push_back(1);
    arr.push_back(2);

    // vector<int> sorted = sort(arr);

    // for(vector<int>::iterator it = sorted.begin(); it != sorted.end(); it++) {
    //     cout << *it << " ";
    // }

    for(vector<int>::iterator it = arr.begin(); it != arr.end(); it++) {
        cout << *it << " ";
    }
}