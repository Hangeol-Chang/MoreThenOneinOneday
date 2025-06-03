#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <unordered_map>
#include <queue>

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
    // v2 로직
    std::priority_queue<int> enemies;

    int now = 0;
    int total_enemy = 0;
    while(true) {
        // printf("now: %d, total_enemy: %d, k: %d\n", now, total_enemy, k);
        if(now >= enemy.size()) { return now; }
        
        int now_enemy = enemy[now];
        total_enemy += now_enemy;
        enemies.push(now_enemy);
        
        if(total_enemy > n) {
            // 무적권 사용 가능할 때.
            if(k > 0) {
                int e = enemies.top();
                enemies.pop();
                total_enemy -= e;
                k--;
            }
            else {
                return now;
            }
        }
        now++;
    }


    // 일부 시관초과 발생한 v1 로직
    // std::unordered_map<int, int> now_soldiers;
    // std::unordered_map<int, int> nex_soldiers;
    // now_soldiers[k] = n;
    // int now = 0;
    // while(true) {
    //     for(const auto& soldier : now_soldiers) {
    //         // 병사 소모
    //         if(soldier.second >= enemy[now]) {
    //             auto it = nex_soldiers.find(soldier.first);
    //             int orig_val = (it != nex_soldiers.end()) ? it->second : 0;
    //             nex_soldiers[soldier.first] = std::max(orig_val, soldier.second - enemy[now]);
    //         }
    //         // 무적권 사용
    //         if(soldier.first > 0) {
    //             auto it = nex_soldiers.find(soldier.first - 1);
    //             int orig_val = (it != nex_soldiers.end()) ? it->second : 0;
    //             nex_soldiers[soldier.first - 1] = std::max(orig_val, soldier.second);
    //         }
    //     }

    //     now_soldiers.swap(nex_soldiers);
    //     nex_soldiers.clear();
    //     nex_soldiers.reserve(now_soldiers.size()); // 다음 라운드에 맞게 버킷 미리 확보

    //     if(now_soldiers.empty()) { break; }
    //     now++;
    //     if(now >= enemy.size()) { break; }
    // }
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