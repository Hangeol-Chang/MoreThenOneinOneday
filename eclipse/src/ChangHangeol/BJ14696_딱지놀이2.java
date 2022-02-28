import java.util.Scanner;

/**
 * 순서대로 많은 사람이 이김.
 * 별		4
 * 동그라미	3		
 * 네모		2
 * 세모		1
 * 다 같으면 무승부
 *
 */
public class BJ14696_딱지놀이2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//테스트 케이스 수
		int T = in.nextInt();
		for(int t = 1; t <= T; t++) {
			int[] acard = new int[4];
			int[] bcard = new int[4];
			//a 입력받기
			int a = in.nextInt();
			for(int i = 0; i < a; i++) { acard[in.nextInt()-1]++; }
			//b 입력받기
			int b = in.nextInt();
			for(int i = 0; i < b; i++) { bcard[in.nextInt()-1]++; }
			
			String DAB = "DAB";
			sb.append(DAB.charAt(compare(acard, bcard, 3)) + "\n");
		}
		System.out.println(sb);
		in.close();
	}
	
	public static int compare(int[] a, int[] b, int index) {
		if(		a[index] > b[index]) return 1;
		else if(a[index] < b[index]) return 2;
		else if(index == 0) return 0;
		else return compare(a, b, index-1);
	}
}
