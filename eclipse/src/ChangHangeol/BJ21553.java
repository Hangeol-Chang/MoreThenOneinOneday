package ChangHangeol;
// import java.util.Scanner;

//언젠가는 풀어보리
// /*
//  * 앞자리에 하나 더하고, 뒤에 하나 더하고 하는 식으로 진행.
//  */
// public class BJ21553 {
// 	static 
// 	public static void main(String[] args) {
// 		Scanner in = new Scanner(System.in);
// 		String A = in.nextLine();
// 		String key = in.nextLine();
		
// 		//mod가 true일 때, 앞자리에 더하기,
// 		System.out.println(patternmaking(A, key, true));
// 		in.close();
// 	}
	
// 	public static String patternmaking(String A, String key, boolean mod) {
// 		if(A.length() == key.length()) return key;
		
// 		boolean[] count = new boolean[9];					//앞, 뒤에 각 자리가 있는지 판단할 배열.
// 		int countcount = 0;
// 		int findidx = 0;
		
// 		while( A.indexOf(key, findidx) != -1) {
// 			int idx = A.indexOf(key, findidx);
			
// 			if(mod) {			
// 				if(idx != 0) {
// 					int tmp = (int)(A.charAt(idx-1)-'0');
// 					if(!count[tmp]) {
// 						countcount++;
// 						count[tmp] = true;
// 					}
// 				}
// 			}else {
// 				if( idx != A.length()-1-key.length() ) {
					
// 				}
// 			}
// 			findidx = idx+key.length()-1;			//-1넣은거는 인덱스에러 방지
// 		}
		
		
// 	}
// 	//패턴메이킹
// 	//case 1 : A1 P1 > 그냥 하나 출력.
	
// 	//앞자리 하나 더했는데 전부 있으면,
// 	//그 모든 앞자리를 더한 수에 대해 다시 패턴메이킹을 진행.
// }
