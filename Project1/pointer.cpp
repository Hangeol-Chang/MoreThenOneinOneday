#include<iostream>
#include<vector>

using namespace std;
int main4() {
	int x = 5;
	int ar[] = { 1, 2, 3, 4, 5 };

	cout << x << '\n';
	cout << &x << '\n';			//�ּҰ�
	cout << *&x << '\n';			//�ּҰ����� ���� �ٽ� �ҷ���


	int *point = &x;		//int�� ������		�����ʹ� �ּҸ� ������
	point = &x;				//�����Ϳ� �ּҰ��� ������
	cout << point << '\n'; 	//����� �� �ּҰ� �ƴ϶� ���� ��µ�
	cout << *point << '\n';	//�������� �ٽ� ���� �ҷ���

	vector<int> v;

	for (int i = 0; i < 5; i++) {
		v.push_back(i);
	}
	for (int i = 0; i < 5; i++) {
		cout << v[i] << " ";
	}
	cout << '\n';

	vector<int> ve = { &ar[0], &ar[5] };

	cout << *ve.begin() << ' '/* << *ve.end() */ ;		//���� ��� �ȵ�

	return 0;
}