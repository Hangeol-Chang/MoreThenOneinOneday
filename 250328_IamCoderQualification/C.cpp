#include <iostream>
#include <vector>

using namespace std;

std::vector<int> map;
std::vector<int> blocks;
int totBlockLength = 0;
int batchCount = 0;
bool answerExist = true;

void run(int startLoc, int blockIndex, std::vector<int> blockLocs) {
    // startLoc -> 돌을 놓을 수 있는 가장 왼쪽 위치.
    // blockIndex -> 현재 놓을 돌.
    
    // 블록을 다 놓았음.
    if(blockIndex == blocks.size()) {
        batchCount++;
        // map에 블록을 배치 
        for(int i = 0; i <= blockLocs.size(); i++) {
            int nowBlocksize = blocks[i];
            int nowBlockLoc = blockLocs[i];

            for(int j = 0; j < nowBlocksize; j++) map[nowBlockLoc + j]++;

            // 블록을 놓은 후, map에 있는 블록의 개수를 확인.
            bool localAnswerExist = false;
            for(int k = 0; k < map.size(); k++)
                if(map[k] == batchCount) { localAnswerExist = true; break; }
            answerExist = localAnswerExist;
        }
        // map print
        for(int i = 0; i < map.size(); i++) {
            if(map[i] == -1) cout << "X ";
            else cout << map[i] << " ";
        }
        printf("\n");
        return;
    }

    int leftBlockSize = 0;
    for(int i = blockIndex; i < blocks.size(); i++) {
        leftBlockSize += blocks[i];
    }

    for(int i = startLoc; i <= map.size() - leftBlockSize; i++) {
        if(!answerExist) return;


        // i번쨰 위치에 블록을 놓을 수 있는지 확인.
        bool canPlace = true;
        for(int j = 0; j < blocks[blockIndex]; j++)
            if(i+j >= map.size() || map[i+j] == -1) { canPlace = false; break; }
        if(!canPlace) continue;

        // 블록을 놓을 수 있음.
        // 블록을 놓고 다음 블록을 놓으러 감.
        std::vector<int> newBlockLocs = blockLocs;
        newBlockLocs.push_back(i);
        // newBLocks debug)
        run(i + blocks[blockIndex], blockIndex + 1, newBlockLocs);
    }
}

int main() {
    int N, M, K;   // M개의 칸, N개의 블록, K개의 X
    cin >> N >> M >> K;
    
    blocks.resize(N);
    for(int i = 0; i < N; i++) {
        cin >> blocks[i];
        totBlockLength += blocks[i];
    }
    std::vector<int> Xs(K);
    for(int i = 0; i < K; i++) cin >> Xs[i];

    map = std::vector<int>(M, 0);
    for(auto x : Xs) { map[x-1] = -1; }

    // map print
    for(int i = 0; i < map.size(); i++) {
        if(map[i] == -1) cout << "X ";
        else cout << map[i] << " ";
    }
    printf("\n");

    run(0, 0, std::vector<int>());

    int ans = 0;
    for(auto x : map) 
        if(x == batchCount) ans++;

    // printf("ans : ");
    printf("%d", ans);
}