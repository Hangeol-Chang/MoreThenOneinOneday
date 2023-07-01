#include<iostream>
#include<algorithm>
#include <vector>

// 이분 탐색으로, 900을 만족하도록 찾아 올라감.
// 최소 300 이상의 메모리 이므로, 300, 300 두 개가 잡히지 않는 한 세 개로 최적화될 경우는 없음.
using namespace std;

int N;	// 프로그램 수
vector<int> progs;

int binarysearch(int st, int target) {
	int ed = progs.size();

	// 나보다 작거나 같은 것 중 최댓값(역순으로 정렬해놓고 lowerbound)
	while(st < ed) {
		int md = (st+ed)/2;
		
		// cout << st << " " << md << " " << ed << " " << progs[md] << " " << target << endl;
		if(progs[md] > target) st = md + 1;	
		else 				   ed = md;
	}
	return ed;
}

int main(int argc, char** argv)
{
	int T;
	cin >> T;
	
	for(int t = 1; t <= T; t++) {
		cin >> N;
		// 벡터 초기화
		progs.clear();
		int count300 = 0;
		for(int i = 0; i < N; i++) {
			int tmp;
			cin >> tmp;
			progs.push_back(tmp);
			if(tmp == 300) count300++;
		}
		// 입력완료

		//내림차순 정렬.
		sort(progs.begin(), progs.end(), [](int a, int b) {
			return a > b;
		});
		
		int servercount = 0;
		// 300보다 큰 애들, 이분탐색으로 반대꺼 찾기.
		for(int i = 0; i < progs.size() - count300; i) {
			int prog = progs[i];
			progs.erase(progs.begin() + i);

			int j = binarysearch(i, 900-prog);
			// 일치하는거 없을 때.
			// if(j >= progs.size())
				// cout << i << " " << prog << " cut " << j << endl;

			if(j < progs.size()){
				if(progs[j] == 300) count300--;
				// cout << i << " " << prog << " " << j << " " << progs[j] << endl;
				progs.erase(progs.begin() + j);
			}
			servercount++;
		}

		// 300만 남게 됨.
		servercount += ((progs.size()+2)/3); 

		cout << servercount << endl;

		// 할당되지 않은 프로그램 처리.
		
	}
	return 0;
}
/*
1
6
300 300 300 600 600 600

1
8
900 500 450 400 300 300 300 300

*/