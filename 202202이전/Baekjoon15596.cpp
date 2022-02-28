#include<vector>
#include<iostream>

using namespace std;

long long sum(std::vector<int>& a) {
	long long ans = 0;
	
	vector<int>::iterator it;

	for (it = a.begin(); it != a.end(); it++) {
		ans += *it;
	}

	//for (int i = 0; i <= a.size(); i++) ans += a[i];		//sdfqwrB KE
	return ans;
}
