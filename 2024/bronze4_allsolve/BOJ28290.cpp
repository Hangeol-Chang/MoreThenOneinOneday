#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    string inp;
    cin >> inp;

    if(inp == "fdsajkl;" || inp == "jkl;fdsa") cout << "in-out";
    else if(inp == "asdf;lkj" || inp == ";lkjasdf") cout << "out-in";
    else if(inp == "asdfjkl;") cout << "stairs";
    else if(inp == ";lkjfdsa") cout << "reverse";
    else cout << "molu";
}