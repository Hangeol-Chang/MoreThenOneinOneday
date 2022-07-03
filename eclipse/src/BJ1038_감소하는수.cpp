#include <iostream>
/*
n번 자리가 x면, n+1번 자리는 n-1까지의 숫자가 올 수 있고, 이는 총 n개의 경우가 됨.
찾아야 되는 위치를 받아 오기.
9 876 543 210 < 최대 수 98억
n = 1022일 때 최대
*/

int main() {
    int n;
    std::cin >> n;

    int count = 0;
    int target[10] = {12, 12, 12, 12, 12, 12, 12, 12, 12, 0};
    while(count < n) {
        target[9]++;

        outer : for(int i = 9; i >= 1; i--) {
            // 자리를 넘겨야 하는 상황.
            if((target[i] != 12 && target[i-1] <= target[i] )|| target[i] == 10) {
                
                // 수 더하기,
                target[i-1] += 1;
                int f = i-1;

                while(target[f] == 10) {
                    if(f == 0) {
                        std::cout << -1;
                        return 0;
                    }
                    target[f--] = 0;
                    target[f] += 1;
                }
                if(target[f] == 13) target[f] = 1;

                // 뒤에를 전부 0으로 초기화.
                for(int j = i; j <= 9; j++) target[j] = 0;
                // 다음 반복 실행.
                
                goto outer;
            }
        }
        // 여기에 오면 다 통과된 것.
        count++;
        // for(int num : target)
        //     std::cout << num << " ";
        // std::cout << std::endl;
    }

    // 정답 출력.
    // std::cout << "\nans ";
    for(int num : target) if(num != 12) std::cout << num;
}