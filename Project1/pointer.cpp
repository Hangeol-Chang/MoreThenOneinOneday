#include<iostream>
#include<vector>

using namespace std;
int main4() {
	int x = 5;
	int ar[] = { 1, 2, 3, 4, 5 };

	cout << x << '\n';
	cout << &x << '\n';			//주소값
	cout << *&x << '\n';			//주소값에서 값을 다시 불러옴


	int *point = &x;		//int형 포인터		포인터는 주소를 저장함
	point = &x;				//포인터에 주소값을 저장함
	cout << point << '\n'; 	//출력할 땐 주소가 아니라 값이 출력됨
	cout << *point << '\n';	//역참조로 다시 값을 불러옴

	vector<int> v;

	for (int i = 0; i < 5; i++) {
		v.push_back(i);
	}
	for (int i = 0; i < 5; i++) {
		cout << v[i] << " ";
	}
	cout << '\n';

	vector<int> ve = { &ar[0], &ar[5] };

	cout << *ve.begin() << ' '/* << *ve.end() */ ;		//저거 출력 안됨

	return 0;
}