#include <iostream>
#include <vector>

struct busLine {
    int start;
    int freq;
    int repeat;
    
    busLine(int s, int f, int r) : start(s), freq(f), repeat(r) {};
};

using namespace std;

int main() {
    int busNum, arriveTime;
    cin >> busNum >> arriveTime;

    vector<busLine> busLines;
    for(int b = 0; b < busNum; b++) {
        int s, f, r; cin >> s >> f >> r;
        busLines.push_back(busLine(s, f, r));
    }
    // 입력 완료.
    int ans = -1;

    for(auto bus = busLines.begin(); bus != busLines.end(); bus++) {
        int depTime = bus->start;
        int freq = bus->freq;
        int repeat = bus->repeat - 1;

        while( depTime < arriveTime && repeat > 0) {
            depTime += freq;
            repeat--;
        }

        if(depTime >= arriveTime) {
            if(ans == -1) ans = depTime - arriveTime;
            else ans = min(ans, depTime - arriveTime);
        }
    }
    
    cout << ans;
}