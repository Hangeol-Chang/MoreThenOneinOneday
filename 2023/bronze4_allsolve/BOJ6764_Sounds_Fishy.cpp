#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> box;
    for(int i = 0; i < 4; i++) {
        int a; cin >> a;
        box.push_back(a);
    }
    
    int coef = box[1] - box[0];
    int idx = 3;

    if(coef == 0) {
        if(box[3] - box[2] == 0 && box[2] - box[1] == 0) 
            idx = 2;
    } 
    else {
        for(auto it = box.begin() + 1; it != box.end() - 1; it++) {
            if( (*(it+1) - *(it)) * coef <= 0 ) 
                goto endpoint; 
        }
        
        if(coef > 0) idx = 0;
        else idx = 1;
    }
    endpoint:;
    switch (idx) {
        case 0 :
            cout << "Fish Rising";
            break;
        case 1 :
            cout << "Fish Diving";
            break;
        case 2 :
            cout << "Fish At Constant Depth";
            break;
        case 3 :
            cout << "No Fish";
            break;
    }

}