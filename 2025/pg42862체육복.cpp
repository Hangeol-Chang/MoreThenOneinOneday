#include <string>
#include <vector>

/*
    바로 앞번호 or 바로 뒷번호에게만 빌려줄 수 있음.
    전체 학생 수 n, 도난당한 번호 lost, 여별의 체육복 배열 reserve, 체육 수업을 들을 수 있는 최댓값?
*/

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector<int> students(n+2, 1);
    
    for(auto l : lost) students[l]--;
    for(auto r : reserve) students[r]++;
    
    for(int i = 1; i <= n; i++) {
        // 빌려야 할 때
        if(students[i] == 0) {
            if(students[i-1] == 2)  {
                students[i-1]--;
                students[i]++;
                continue;
            }
            if(students[i+1] == 2) {
                students[i+1]--;
                students[i]++;
                continue;
            }
        }
    }
    
    int answer = 0;
    for(int i = 1; i <= n; i++) {
        if(students[i] > 0) answer++;
    }
    return answer;
}