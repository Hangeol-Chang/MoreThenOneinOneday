#include <iostream>
#include <map>
#include <vector>
#include <sstream>

using namespace std;

int idOdd(int year) {
    if( year % 400 == 0)     return 1;
    else if(year % 100 == 0) return 0;
    else if(year % 4 == 0)   return 1;
    return 0;
}

map<string, int> months = {
    {"January", 1},
    {"February", 2},
    {"March", 3},
    {"April", 4},
    {"May", 5},
    {"June", 6},
    {"July", 7},
    {"August", 8},
    {"September", 9},
    {"October", 10},
    {"November", 11},
    {"December", 12},
};

// 입력 그지같이주네 증말.
int main() {
    string line;
    vector<string> inputs;

    getline(cin, line);
    stringstream stream(line);

    string tmp;
    while(getline(stream, tmp, ' ')) {
        inputs.push_back(tmp);
    }

    int month = months.find(inputs[0])->second;
    int year = stoi(inputs[2]);
    int day = stoi(inputs[1].substr(0, inputs[1].length() - 1));

    int hour = stoi(inputs[3].substr(0, 2));
    int min = stoi(inputs[3].substr(3, 2));

    int odd = idOdd(year);

    int full = 24 * 60 * ( 365 + odd );
    int totmin = min;
    totmin += hour * 60;
    totmin += (day - 1) * 24 * 60;
    
    for (int m = 1; m < month; m++) {
        int num;
        if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) num = 31;
        else if(m == 4 || m == 6 || m == 9 || m == 11) num = 30;
        else num = 28 + odd;

        totmin += num * 24 * 60;
    }
    
    double ans = 100.0 * totmin / full;
    printf("%.15f\n", ans);
    // cout << totmin << " / " << full;
}