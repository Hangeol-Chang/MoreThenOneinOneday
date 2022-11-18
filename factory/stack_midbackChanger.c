#include <stdio.h>

char stk[100];
int stkSize = 0;

void main() {

    // printf("Input calc : ");
    char sik1[100] = "3*(2+4)-4/2+3*(2*(5+4))";
    int sik1Size = 0;

    char sik2[100];
    int sik2Size = 0;

    int totSize = 0;

    while(sik1[sik1Size]) {
        char now = sik1[sik1Size++];

        if(now >= '0' && now <= '9') sik2[sik2Size++] = now;
        else {
            if(now == ')')
                while(stk[--stkSize] != '(') sik2[sik2Size++] = stk[stkSize];
            else 
                stk[stkSize++] = now;
        }
        totSize++;
    }

    while(stkSize >= 0) sik2[sik2Size++] = stk[--stkSize];
    for(int i = 0; i < totSize; i++) printf("%c", sik2[i]);
}