#include <iostream>

using namespace std;

int main() {
    int kor = 0, eng = 0, math = 0, search = 0, lang = 0;
    int id = 0;

    int N; cin >> N;

    cin >> kor;
    if(N >= 2) cin >> math;
    if(N >= 3) cin >> eng;
    if(N >= 4) cin >> search;
    if(N == 5) cin >> lang;

    if(kor > eng) id += (kor - eng) * 508;
    else id += (eng - kor) * 108;

    if(math > search) id += (math - search) * 212;
    else id += (search - math) * 305;

    id += lang * 707;

    id *= 4763;
    cout << id;
}