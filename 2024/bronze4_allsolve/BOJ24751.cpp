#include <iostream>

using namespace std;

int main() {
    int per; cin >> per;
    
    printf("%.10f\n%.10f", (100.0 / per), (100.0 / (100 - per)));
}