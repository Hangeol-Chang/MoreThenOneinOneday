#include <iostream>
#include <string.h>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    int matrix[n][m];
    memset(matrix, 0, sizeof(matrix));

    for(int t = 0; t < 2; t++){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int tmp;
                cin >> tmp;
                matrix[i][j] += tmp;
            }
        }
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
}