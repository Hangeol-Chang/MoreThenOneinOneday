#include <iostream>

using namespace std;

int main() {
    while(true) {
        double i;
        cin >> i;
        if(i < 0) return 0;

        printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", i, 0.167 * i);
    }
}