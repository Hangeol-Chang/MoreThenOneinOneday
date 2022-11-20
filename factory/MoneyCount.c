#include <stdio.h>

int input() {
    int pay;
    printf("pay : ");
    scanf_s("%d", &pay);
    return pay;
}

static int bills[] = {10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

void devide(int money) {

    printf("\n");
    int billcount = sizeof(bills)/sizeof(bills[0]);
    for(int i = 0; i < billcount; i++) {
        int bill = bills[i];
        
        int count = 0;
        while(money > bill) {
            money -= bill;
            count++;
        }
        printf("%5d Count : %d\n", bill, count);
    }

    printf("\n\n");
    return;
}

int isY() {
    char c;
    printf("Continue (y/n) : ");
    scanf_s("%c", &c);
    
    return c == 'y' ? 1 : 0;
}

void main() {

    while(1) {
        devide(input());
        fflush(stdin);
        if(!isY()) return;
    }
}