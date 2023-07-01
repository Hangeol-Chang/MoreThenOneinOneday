#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b;
    cin >> a >> b;

    int arr[a];
    int brr[b];
    for(int i = 0; i < a; i++) cin >> arr[i];
    for(int i = 0; i < b; i++) cin >> brr[i];

    int ap = 0;
    int bp = 0;
    
    while(ap < a && bp < b) {
        if(arr[ap] < brr[bp]) cout << arr[ap++] << " ";
        else                  cout << brr[bp++] << " ";
    }
    while(ap < a) cout << arr[ap++] << " ";
    while(bp < b) cout << brr[bp++] << " ";
}