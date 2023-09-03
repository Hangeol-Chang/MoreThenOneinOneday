#include <iostream>
#include <unordered_map>
#include <sstream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

    int T; 
    cin >> T;
    cin.ignore();
    
    unordered_map<long long, int> mm;
    
    for(int t = 1; t <= T; t++) {
        mm.clear();

        string line;
        getline(cin, line);

        stringstream text_stream(line);
        string item;

        getline(text_stream, item, ' ');
        int N = stoi(item);
        
        int limit = N/2 + 1;
        long long occupied = 0;

        long long tmpnum; 
        while(std::getline(text_stream, item, ' ')) {
            tmpnum = stol(item);
            
            mm[tmpnum]++;

            if(mm[tmpnum] >= limit) {
                occupied = tmpnum;
                break;
            } 
        }

        if(occupied)    cout << occupied << "\n";
        else                cout << "SYJKGW\n";
    }
    return 0;
}