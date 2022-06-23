#include <iostream>

using namespace std;

int binary_search(int count, int value, int left, int right) {
    int mid = (left + right) / 2;

    if(mid == value) return count;
    else if(value < mid)
        return binary_search(count + 1, value, left, mid-1);
    else
        return binary_search(count + 1, value, mid+1, right);
}

int ternary_search(int count, int value, int left, int right) {   
    int left_third = left + (right - left) / 3;
    int right_third = right - (right - left) / 3;
    
    // 하나도 참조하지 않음.
    if(left_third == value) return count;
    // left_third만 참조함.
    else if(right_third == value) return count + 1;
    // left_third, right_third 다 참조함.
    else if(value < left_third)  return ternary_search(count + 2, value, left, left_third -1);
    else if(value < right_third) return ternary_search(count + 2, value, left_third +1, right_third -1);
    else                         return ternary_search(count + 2, value, right_third +1, right);
}

int main() {
    int n;
    cin >> n;
    
    int a = 0;
    int b = 0;
    int c = 0;
    for(int i = 0; i < n; i++){
        int bc = binary_search(0, i, 0, n-1);
        int tc = ternary_search(0, i, 0, n-1);

        cout << bc << " " << tc << endl;
        if(bc < tc) a++;
        else if(bc == tc) b++;
        else c++;
    }
    
    printf("%d\n%d\n%d", a, b, c);
}