#include<iostream>


using namespace std;

int main(int argc, char** argv)
{
	// 학생 수, 구간(테스트케이스) 수
	int N, K;
	cin >> N >> K;
	int nums[N+1];
	nums[0] = 0;
	
	for(int i = 1; i <= N; i++) {
		int tmp;
		cin >> tmp;
		nums[i] = tmp + nums[i-1];
	}

	for(int i = 0; i < K; i++) {
		int st, ed;
		cin >> st >> ed;
		double ans = (nums[ed] - nums[st-1])*1.0 / (ed - st + 1);

		printf("%.2f\n", ans);
	}

	return 0;
}