// #include <iostream>
// #include <vector>

// using namespace std;

// static int N;
// /*
//     잡히지 않읗 확률이 제일 높은 것으로.
// */

// struct Loc {
//     double percent;
//     std::vector<int> log;
//     Loc() : percent(0.0), log(std::vector<int>(0, 0)) {}
// };
// std::vector<Loc> locs;

// double unCaughtPercents(int remain, int jump) {
//     return (1.0 - (double)jump / (remain+1));
// }

// void run2(int n) {
//     if(n == N+1) return;
//     Loc now = locs[n];

//     printf("now loc %d, percent: %.4f\n", n, now.percent);

//     // i번쨰에서 온다.
//     for(int i = 0; i < n; i++) {
//         if(locs[i].percent < now.percent) continue;
//         double unCaught = unCaughtPercents(N - (n-1), n - i);
//         double percent = locs[i].percent * unCaught;
        
//         if(percent > now.percent) {
//             printf("n: %d, i: %d, unCaught: %.4f, percent: %.4f\n", n, i, unCaught, percent);

//             locs[n].percent = percent;
//             std::vector<int> log = locs[i].log;
//             log.push_back(n-i);
//             locs[n].log = log;
//         }
//     }
//     printf("\n");

//     run2(n+1);
// }

// // 가능한 곳까지 다 뛰어넘어봄.
// // void run(int n) {
// //     // n -> 내 현재 위치,
// //     // x -> 내가 뛰어넘을 사람 수 .
// //     // n + x <= N 이어야 함.
// //     Loc now = locs[n];

// //     for(int x = 1; x <= N - n; x++) {
// //         double unCaought = unCaughtPercents(N - n, x);
// //         double percent = now.percent * unCaought;
// //         // printf("n: %d, x: %d, unCaught: %.4f, percent: %.4f\n", n, x, unCaought, percent);

// //         if (percent <= locs[N].percent ||
// //             percent <= locs[n + x].percent) 
// //         { continue; }

// //         locs[n + x].percent = percent;
// //         std::vector<int> log = now.log;
// //         log.push_back(x);
// //         locs[n + x].log = log;
// //         locs[n + x].percent = percent;

// //         run(n + x);
// //         // cout << "n: " << n << ", x: " << x << ", percent: " << percent << endl;
// //     }
// //     // printf("loc %d ended\n\n", n);
// // }

// int main() {
//     cin >> N;
//     locs = std::vector<Loc>(N+1, Loc());
//     locs[0].percent = 1.0;

//     run2(0);

//     // printf("ans\n");
//     printf("%d\n", locs[N].log.size());
//     for(auto i : locs[N].log) {
//         printf("%d ", i);
//     }
//     return 0;
// }

#include <iostream>
using namespace std;
int main() {
    int N; cin >> N;
    printf("%d\n", N);
    for(int i = 1; i <= N; i++) {
        printf("%d ", 1);
    }
}