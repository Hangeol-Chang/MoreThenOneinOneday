#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> cranes;
vector<int> boxs;

int lowbound(int stIdx, int edIdx, int val) {
    int l = stIdx;
    int r = edIdx;
    int midIdx;

    while(l < r) {
        midIdx = (l + r) / 2;;

        int cmp = boxs[midIdx];
        if (cmp <= val) r = midIdx;
        else            l = midIdx + 1;

        // cout << l << " " << r << " " << midIdx << endl;

        // Sleep(100);
    }
    return r;
}


int main() {
    int craneNum; cin >> craneNum;
    cranes.reserve(craneNum);

    for(int i = 0; i < craneNum; i++) {
        int tmp; cin >> tmp;
        cranes.push_back(tmp);
    }

    int boxNum; cin >> boxNum;
    boxs.reserve(boxNum);

    for(int i = 0; i < boxNum; i++) {
        int tmp; cin >> tmp;
        boxs.push_back(tmp);
    }

    sort(cranes.rbegin(), cranes.rend());
    sort(boxs.rbegin(), boxs.rend());

    if( boxs[0] > cranes[0] ) {
        cout << -1;
        return 0;
    }

    int turn = 0;
    while(!boxs.empty()) {
        turn++;

        for(vector<int>::iterator it = cranes.begin(); it != cranes.end(); it++) {
            if(!boxs.empty()) {
                // cout << "find : " <<  *it << "\n";
                int moveIdx = lowbound(0, boxs.size() - 1, *it);

                // cout << "res : " << moveIdx << endl;
                if (boxs[moveIdx] > *it) goto next;
                boxs.erase(boxs.begin() + moveIdx);

                // cout << "sorted : ";
                // for(vector<int>::iterator it = boxs.begin(); it != boxs.end(); it++) {
                //     cout << *it << " ";
                // }
                // cout << "\n\n";
            }

            else goto outer;
        }
        next:;
    }
    outer:;
    cout << turn;
}


/*

2
20 8
10
18 12 3 17 4 7 15 1 2 19

3
20 8 40
16
18 12 3 17 4 7 15 1 2 19 37 32 21 20 33 8

*/