#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <unordered_map>

/*
    병사 N명으로, 적의 공격을 순서대로 막는다.

    매 라운드 enemy[i] 마리의 적이 등장함.
    남은 병사 중 enemy[i]명을 소모하여 enemy[i]를 막는다.
    막을 수 없는 상황 -> 게임 종료
    
    무적권 -> k번 사용가능. 병사 소모 없이 공격 막음.

    n -> 병사 수
    k -> 무적권 사용 횟수
    enemy_len -> enemy의 수
    
*/

int solution(int n, int k, std::vector<int> enemy) {
    std::unordered_map<int, int> now_soldiers;
    std::unordered_map<int, int> nex_soldiers;

    now_soldiers[k] = n;

    int now = 0;
    while(true) {
        // Debug
        // printf("Round: %d\n", now);
        // printf("Now soldiers: \n");
        // for(const auto& soldier : now_soldiers) {
        //     printf("soldier - (%d, %d)\n", soldier.first, soldier.second);
        // }
        // printf("\n");

        for(const std::pair<int, int>& soldier : now_soldiers) {
            if(soldier.second >= enemy[now]) {
                int orig_val = 0;
                if(nex_soldiers.find(soldier.first) != nex_soldiers.end()) {
                    orig_val = nex_soldiers[soldier.first];
                }
                nex_soldiers[soldier.first] = std::max(orig_val, soldier.second - enemy[now]);
            }
            if(soldier.first > 0) {
                int orig_val = 0;
                if(nex_soldiers.find(soldier.first - 1) != nex_soldiers.end()) {
                    orig_val = nex_soldiers[soldier.first - 1];
                }
                nex_soldiers[soldier.first - 1] = std::max(orig_val, soldier.second);
            }
        }

        // 다음 라운드용 정리.
        now_soldiers.swap(nex_soldiers);
        nex_soldiers.clear();

        // 못 통과했으면 break;
        if(now_soldiers.empty()) { break; }
        now++;
        if(now >= enemy.size()) { break; }
    }
    return now;
}

struct TestCase {
    int n;
    int k;
    std::vector<int> enemy;
    int expected;
};

int main() {
    TestCase test_cases[] = {
        {7, 3, {4, 2, 4, 5, 3, 3, 1}, 5},
        {2, 4, {3, 3, 3, 3}, 4}
    };

    for(auto test_case : test_cases) {
        // res 초기화.

        int res = solution(test_case.n, test_case.k, test_case.enemy);
        printf("expected: %d, result: %d\n", test_case.expected, res);
    }
}