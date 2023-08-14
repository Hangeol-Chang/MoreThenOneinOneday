#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct cost {
    int price;
    int delivery;

    cost(int pin, int din) : price(pin), delivery(din) {};
};

bool costCmp(const cost& c1, const cost& c2) {
    if(c1.price < c2.price) return true;
    else return false;
}

int main() {

    vector<cost> vec;

    int N; cin >> N;


    for(int i = 0; i < N; i++) {
        int a, b;
        cin >> a >> b;
        if(a <= b) continue;

        vec.push_back(cost(a, b));   
    }

    int sellprice = 0;
    int benefit = 0;

    int size = vec.size();
    sort(vec.begin(), vec.end(), costCmp);

    for(int i = 0; i < size; i++) {
        int targetcost = vec[i].price;
        int nowBenefit = 0;

        for(int j = i; j < size; j++) 
            if(targetcost - vec[j].delivery > 0)
                nowBenefit += targetcost - vec[j].delivery;
        
        // cout << targetcost << " " << nowBenefit << endl; 
        if(nowBenefit > benefit) {
            benefit = nowBenefit;
            sellprice = targetcost;
        }
    }

    cout << sellprice << endl;
}