#include <stdio.h>

#define MAXNUM 100000
static int save[MAXNUM] = {0, 1, };

int fibo(int num) {
    if(num <= 1) return num;
    else {
        
        if(save[num]) return save[num];
        else {
            save[num] = (fibo(num-1) + fibo(num-2));
            return save[num];
        }
    }
}

void main() {
    int num;
    printf("Input number : ");
    scanf_s("%d", &num);

    fibo(num);
    for(int i = 1; i <= num; i++) printf("%d ", save[i]);
}