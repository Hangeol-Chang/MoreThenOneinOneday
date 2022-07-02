#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;
    
    int quo = N/4;
    for(int i = 0; i < quo; i++) cout << "long ";
    cout << "int" << endl;
}