#include <iostream>
#include <set>
#include <vector>
#include <cstring>

// fail > Segfault

using namespace std;

int main() {
    set<string> a;

    char **input;
    int n;
    cin >> n;

    input = (char **)malloc(n * sizeof(char *));

    for(int i = 0; i < n; i++) {
        input[i] = (char *)malloc(100);
        cin >> input[i];
    }

    int len = 0;
    for(char *c = input[0]; *c != '\0'; c++) { len++; } 
    int totlen = len;

    while(true) {
        a.clear();

        len--;
        for(int i = 0; i < n; i++) {

            pair<set<string>::iterator, bool> res = a.insert(string(input[i] + len));
            // cout << *(res.first) << endl;
            if(!res.second) goto cont; 
        }

        break;
        cont:;
        // cout << endl;
    }

    cout << totlen - len;
}

/*

input -

n = 2 ~ 1000 까지의 숫자 중 하나
n개의 줄에 걸쳐서{
    최대 100자리의 숫자
}

*/