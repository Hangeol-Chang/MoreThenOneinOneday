#include <iostream>
#include <vector>

using namespace std;

int main() {
    int G;
    cin >> G;

    vector<int> ans;
    int n = 1;
    int x = 1;
    while(true) {
        if( x == 1 && 2*n*x + x*x > G ) break;

        cout << "new cycle n : " << n << endl;
        while(true) {
            cout << "n : " << n << ", x : " << x; 
            int idf = 2*n*x + x*x;
            if(idf >= G) {
                if(idf == G) {
                    cout << " pass" ;
                    ans.push_back(n+x);
                }
                cout << endl;
                break;
            }
            else x++;
            cout << endl;
        }
        x--;
        if(x == 0) x = 1;
        n++;
    }
    
    if(ans.empty()) cout << -1;
    else
        for(int i=0; i < ans.size(); i++)
            cout << ans[i] << endl;
}


/*

(n+x)^2 - n^2
>> 2nx + x^2 = G

*/