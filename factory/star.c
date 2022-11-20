#include <stdio.h>

void triangle1(int num) {
    for(int i = 1; i <= num; i++) {
        for(int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }
    printf("\n");

    return;
}

void triangle2(int num) {
    for(int i = num; i >= 1; i--) {
        for(int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }
    printf("\n");

    return;
}

void triangle3(int num) {
    for(int i = 1; i <= num; i++) {
        for(int j = 1; j <= num - i; j++) printf(" ");
        for(int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }
    printf("\n");

    return;
}

void triangle4(int num) {
    for(int i = num; i >= 1; i--) {
        for(int j = 1; j <= num - i; j++) printf(" ");
        for(int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }
    printf("\n");

    return;
}

void diamond(int num) {
    for(int i = 1; i <= num; i += 2) {
        int rep = (num - i)/2;
        for(int j = 1; j <= rep; j++) printf(" ");
        for(int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }

    for(int i = num-2; i >= 1; i -= 2) {
        int rep = (num - i)/2;
        for(int j = 1; j <= rep; j++) printf(" ");
        for(int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }
    printf("\n");

    return;
}

void sandglass(int num) {
    for(int i = num; i >= 1; i -= 2) {
        int rep = (num - i)/2;
        for(int j = 1; j <= rep; j++) printf(" ");
        for(int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }
    for(int i = 1; i <= num; i += 2) {
        int rep = (num - i)/2;
        for(int j = 1; j <= rep; j++) printf(" ");
        for(int j = 1; j <= i; j++) printf("*");
        printf("\n");
    }
    printf("\n");

    return;
}

void rectangleEmpty(int num) {
    for(int i = 1; i <= num; i++) {
        for(int j = 1; j <= num; j++) {
            if(i == 1 || j == 1 || i == num || j == num) printf("*");
            else printf(" ");
        }
        printf("\n");
    }
    printf("\n");

    return;
}

void main() {
    printf("input num : ");
    int num;
    scanf_s("%d", &num);
    
    num = num/2 * 2 + 1;

    triangle1(num);
    triangle2(num);
    triangle3(num);
    triangle4(num);
    diamond(num);
    sandglass(num);
    rectangleEmpty(num);

    return;
}
