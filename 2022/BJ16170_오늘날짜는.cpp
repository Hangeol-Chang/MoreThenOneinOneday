#include<ctime>
#include<iostream>
using namespace std;

int main() {
    time_t timer = time(NULL);
    struct tm* t;
    t = gmtime(&timer);

    printf("%04d\n", t->tm_year + 1900);
    printf("%02d\n", t->tm_mon + 1);
    printf("%02d\n", t->tm_mday);
}