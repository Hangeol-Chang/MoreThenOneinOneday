#include <iostream>
#include <unordered_map>
#include <string>
#include <sstream>

using namespace std;

int main() {
    int T; cin >> T;
    
    for(int t = 1; t <= T; t++) {
        int N; cin >> N;
        int half = N/2;

        unordered_map<long long, int> mm;
        int occupied = 0;
    
        for(int i = 1; i < N; i++) {
            string line;
            getline(cin, line);

            stringstream text_stream(line);
            string item;
            
            getline(text_stream, item, ' ');

            unordered_map<long long, int>::iterator it = mm.find(tmpnum);
            while(std::getline(text_stream, item, ' ')) {
                int tmpnum = stoi(item);
                int q = 0;
                
                if(it != mm.end()) {
                    mm[tmpnum] = it->second + 1;
                    q = it->second + 1;
                }
                else {
                    mm[tmpnum] = 1;
                    q = 1;
                }
                if(q > N/2) {
                    occupied = tmpnum;
                    break;
                }
            }

        }
        cin.ignore();
        if(occupied > 0) {
            cout << occupied << "\n";
        }
        else  cout << "SYJKGW\n";
    }
}