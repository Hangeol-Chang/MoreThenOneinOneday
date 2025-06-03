#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

bool ContainsZero(const vector<int>& vec) {
    for(auto v : vec) {
        if(v == 0) return true;
    }
    return false;
}

bool NotContainsZero(const vector<int>& vec) {
    for(auto v : vec) {
        if(v == 0) return false;
    }
    return true;
}

struct Ans {
    int p1;
    int p2;
    int len;
    
    Ans(int a, int b) : p1(a), p2(b), len(b - a) {}
};

vector<int> solution(vector<string> gems) {
    unordered_map<string, int> gemMap{};
    std::vector<int> gemInts{};
    
    int gemIndex = 0;
    for(const auto& gem : gems) {
        if(gemMap.find(gem) == gemMap.end()) {
            gemMap[gem] = gemIndex++;
        }
        gemInts.push_back(gemMap[gem]);
    }
    
    vector<int> buyGems(gemIndex, 0);
    
    Ans ans(1, gems.size());
    
    int p1 = 0;
    int p2 = 0;
    while(p2 < gems.size() && p1 < gems.size()) {
        while(p2 < gems.size() && ContainsZero(buyGems)) {
            buyGems[gemInts[p2++]]++;
        }
        while(p1 < gems.size() && NotContainsZero(buyGems)) {
            buyGems[gemInts[p1++]]--;
        }
        
        // 여기서 정답 처리.
        // printf("p1 p2 | %d %d || ans %d %d \n", p1, p2, ans.p1, ans.p2);
        if(p2 - p1 < ans.len) {
            ans.p1 = p1;
            ans.p2 = p2;
            ans.len = p2 - p1;
        }
    }

    return {ans.p1, ans.p2};
}

int main() {
    std::vector<std::vector<string>> gems = {
        {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},
        {"AA", "AB", "AC", "AA", "AC"},
        {"XYZ", "XYZ", "XYZ"},
        {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
    };

    for(const auto& gem : gems) {
        // printf("gems: ");
        // for(const auto& g : gem) {
        //     printf("%s ", g.c_str());
        // }
        // printf("\n");
        std::vector<int> ans = solution(gem);
        printf("ans: %d %d\n", ans[0], ans[1]);
    }
    return 0;
}