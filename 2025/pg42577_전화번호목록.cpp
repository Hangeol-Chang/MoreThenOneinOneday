// #include <string>
// #include <cstring>
// #include <vector>
// #include <functional>
// #include <map>
// #include <set>

// using namespace std;

// bool solution(vector<string> phone_book) {
//     std::hash<string> str_hash;
    
//     // std::map<int, std::vector<size_t>> hashMap;
//     std::map<int, std::vector<string>> hashMap;
//     std::set<int> keys;
    
//     for(auto number : phone_book) {
//         // size_t hash = str_hash(number);
//         int len = strlen(number.c_str());
        
//         if(hashMap.find(len) == hashMap.end()) {
//             // hashMap.insert({len, vector<size_t>()});
//             hashMap.insert({len, vector<string>()});
//             keys.insert(len);
//         }
//         hashMap[len].push_back(number);
//     }
    
//     for(auto key : keys) {
//         vector<string> cmps = hashMap[key];

//         for(int target = key+1; target < 20; target++) {
//             if(hashMap.find(target) == hashMap.end()) continue;
//             for(string v : hashMap[target]) {
//                 string parted = v.substr(0, key);
                
//                 for(auto cmp : cmps) {
//                     if(strcmp(parted.c_str(), cmp.c_str()) == 0) {
//                         return false;
//                     }
//                 }
//             }
//         }
//     }
    
//     return true;
    
//     // for(auto it : hashMap) {
//     //     printf("%d ", it.first);
//     //     for(auto v : it.second) {
//     //         printf("%lu ", v);
//     //     }
//     //     printf("\n");
//     // }    
// }

// //

// #include <string>
// #include <cstring>
// #include <vector>
// #include <functional>
// #include <map>
// #include <set>

// using namespace std;

// bool solution(vector<string> phone_book) {    
//     std::map<int, std::vector<std::vector<int>>> hashMap;
//     std::set<int> keys;
    
//     for(auto number : phone_book) {
//         int len = strlen(number.c_str());
        
//         if(hashMap.find(len) == hashMap.end()) {
//             hashMap.insert({len, vector<vector<int>>()});
//             keys.insert(len);
//         }
        
//         vector<int> a;
//         for(int i = 0; i < len; i++) {
//              a.push_back(stoi(number.substr(i, 1)));
//         }
//         hashMap[len].push_back(a);
//     }
    
//     for(auto key : keys) {
//         vector<vector<int>> cmps = hashMap[key];

//         for(int target = key+1; target < 20; target++) {
//             if(hashMap.find(target) == hashMap.end()) continue;
//             for(vector<int> v : hashMap[target]) {
//                 for(auto cmp : cmps) {
//                     for(int i = 0; i < key; i++) {
//                         if(cmp[i] != v[i]) {
//                             goto outer;
//                         }
//                     }
//                     return false;
//                     outer:;
//                 }
//             }
//         }
//     }
    
//     return true;
// }

#include <string>
#include <cstring>
#include <vector>
#include <functional>
#include <set>
#include <unordered_set>

using namespace std;

auto cmp = [](const string& a, const string& b) {
    if (a.length() == b.length()) return a < b;
    return a.length() < b.length();
};

bool solution(vector<string> phone_book) {
    std::hash<string> hash_str;
    std::set<int> keys;
    std::set<string, decltype(cmp)> ordered_number(cmp);
    
    for(auto number : phone_book) {
        int len = strlen(number.c_str());
        keys.insert(len);
        ordered_number.insert(number);
    }
    
    std::unordered_set<size_t> num_hash;
    // for(auto key : keys) {
    //     printf("%d\n", key);
    // }

    for(auto number : ordered_number) {
        int len = strlen(number.c_str());
        
        for(auto key : keys) {
            if(key > len) break;
            
            size_t s = hash_str(number.substr(0, key));
            // printf("%s %s %lu \n", number.c_str(), number.substr(0, key).c_str(), s);
            if(num_hash.find(s) == num_hash.end()) {
                if(key == len) num_hash.insert(s);
            }
            else {
                return false;
            }
        }
    }
    return true;
}

int main() {
    // vector<string> phone_book = {"97674223", "1195524421", "119"};
    // vector<string> phone_book = {"123", "456", "789"};
    // vector<string> phone_book = {"12", "123", "1235", "567", "88"};
    // vector<string> phone_book = {"12", "123", "1235", "567", "88", "1234567890"};
    // vector<string> phone_book = {"1234567890", "12345678901", "123456789012", "1234567890123", "12345678901234", "123456789012345", "1234567890123456", "12345678901234567", "123456789012345678", "1234567890123456789"};

    vector<string> phone_book = {"9", "10", "11"};

    bool result = solution(phone_book);
    printf("%s\n", result ? "true" : "false");

    return 0;
}