#include <iostream>

using namespace std;

int main() {
    // 테스트 그룹의 수 || 그룹당 인원수 || 양성 그룹 수
    int a, b, c; cin >> a >> b >> c;
    
    int gr = a + c*b;
    int id = a*b;

    if(id < gr) cout << 1;
    else if(id > gr) cout << 2;
    else cout << 0;
}