#include <stdio.h>

void main() {
    short ss = 0x8c;
    signed char sc = 0x8c;

    printf("%x\n", (int)ss);
    printf("%x\n", (int)sc);
}