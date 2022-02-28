#include <iostream> 
#include <vector> 

using namespace std; 

void main3() 
{ 
	int ari[]={5,6,7,8,9}; 
	vector<int> vi(&ari[0],&ari[5]); 
	vector<int>::iterator it;
	
	for (it=vi.begin();it!=vi.end();it++) { 
		printf("%d\n",*it); 
	} 


}
