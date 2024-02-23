#include <iostream>

using namespace std;

int main() {
    string emoji; cin >> emoji;
    
    int length = emoji.length();
    int collon = 0;
    int underbar = 0;
    
    for(char c : emoji) {
        if(c == ':') ++collon;
        else if(c == '_') ++underbar;
    }

    cout << length + collon + underbar*5;
}