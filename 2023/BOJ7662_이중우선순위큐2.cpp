// maxheap, minheap을 구현하는 형태로 다시 짤 것.
#include <iostream>
#include <vector>

using namespace std;

// 1이면 maxHeap, -1이면 minHeap
void insert(vector<int> *heap, int num, int Mm) {
    // 맨 뒤에 넣고, 자기보다 ~~ 한 한 계속 올리기.
    heap->push_back(num);
    
}