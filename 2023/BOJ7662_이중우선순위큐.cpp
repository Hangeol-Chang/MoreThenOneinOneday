#include <iostream>

using namespace std;

typedef struct node {
    int value;
    struct node *left;
    struct node *right;

    node() : left(NULL), right(NULL) {};
    node(int valin) : value(valin), left(NULL), right(NULL) {};
} NODE;

node *tree;
int treesize = 0;

void insert(int val) {
    treesize++;
    node *newNode = (node *)malloc(sizeof(node));
    newNode->value = val;
    newNode->left = NULL;
    newNode->right = NULL;

    if(tree == NULL) {
        tree = newNode;
        return;
    }
    
    node *now = tree;
    
    while(true) {
        // val이 더 작을때,
        if(val < now->value) {
            if(now->left == NULL) {
                now->left = newNode;
                break;
            }
            now = now->left;
        }
        // val이 같거나 클 때

        else {
            if(now->right == NULL) {
                now->right = newNode;
                break;
            }
            now = now->right;
        }
    }
}

void remove(int idf) {
    // tree에 데이터 빈 경우
    if(treesize == 0) return;
    treesize--;

    // idf가 1이면 최댓값,
    // idf가 -1이면 최솟값을 지움.
    node *now = tree;
    node *prev = NULL;
    if(idf == 1) {
        // 오른쪽으로 끝까지 내려가기.
        while(now->right != NULL) {
            prev = now;
            now = now->right;
        }
        if(prev != NULL) prev->right = now->left;
        else tree = now->left;
    }
    else {
        // 왼쪽으로 끝까지 내려가기.
        while(now->left != NULL) {
            prev = now;
            now = now->left;
        }
        if(prev != NULL) prev->left = now->right;
        else tree = now->right;
    }
}

int getMax() {
    node *now = tree;
    while(now->right != NULL) now = now->right;
    return now->value;
}
int getMin() {
    node *now = tree;
    while(now->left != NULL) now = now->left;
    return now->value;
}

int main() {
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        treesize = 0;
        tree = NULL;

        // 명령 수
        int N; cin >> N;
        for(int n = 1; n <= N; n++) {
            char c;
            int val;
            cin >> c >> val;

            switch(c) {
                case 'I' : insert(val); break;
                case 'D' : remove(val); break;    
            }   
        }
        if(treesize == 0) cout << "EMPTY\n";
        else cout << getMax() << " " << getMin() << "\n";
    }
}

// 숫자 크기대로 정렬.

/*

1
7
I 16
I -5643
D -1
D 1
D 1
I 123
D -1

*/