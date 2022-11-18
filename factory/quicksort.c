#include <stdio.h>

int arr[] = {3, 5, 7, 11, 74, 2, 89, 4, 1, 88, 100, 9, 8};

void qsort(int st, int ed) {
    if(st >= ed) return;

    int pivot = arr[st];
    int l = st+1;
    int r = ed;

    while(1) {
        while(l <= ed && arr[l] <= pivot) l++;
        while(r >  st && arr[r] >= pivot) r--;

        if(l >= r) break;

        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    arr[st] = arr[r];
    arr[r] = pivot;
    
    // printf("%3d %3d || ", st, ed);
    // for(int i = 0; i < 13; i++) printf("%3d", arr[i]);
    // printf("\n");
    
    qsort(st, r-1);
    qsort(r+1, ed);

    return;
}

void main() {

    int size = sizeof(arr)/sizeof(arr[0]);

    qsort(0, size - 1);

    for(int i = 0; i < size; i++) printf("%4d", arr[i]);
    return;
}