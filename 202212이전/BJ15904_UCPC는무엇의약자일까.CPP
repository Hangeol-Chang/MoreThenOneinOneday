#include <iostream>
#include <string.h>

using namespace std;

int main() {
    string ref = "UCPC";
    
    string str;
    getline(cin, str);
    
    int len = str.size();

    int refidx = 0;
    int stridx = 0;

    while(refidx < 4 && stridx < len) {
        if(ref.at(refidx) == str.at(stridx))
            refidx++;
        stridx++;
    }

    cout << "I ";
    if(refidx == 4) cout << "love";
    else            cout << "hate";
    cout << " UCPC" << endl;
}