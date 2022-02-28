import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스트링토크나이저 사용하면, 속도가 어케 되나
 * 순서대로 많은 사람이 이김.
 * 별		4
 * 동그라미	3		
 * 네모		2
 * 세모		1
 * 다 같으면 무승부
 *
 */
public class BJ14696_딱지놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트 케이스 수
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			int[] acard = new int[4];
			int[] bcard = new int[4];
			//a 입력받기
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int i = 0; i < a; i++) { acard[Integer.parseInt(st.nextToken())-1]++; }
			//b 입력받기
			st = new StringTokenizer(in.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int i = 0; i < b; i++) { bcard[Integer.parseInt(st.nextToken())-1]++; }
			
			String DAB = "DAB";
			sb.append(DAB.charAt(compare(acard, bcard, 3)) + "\n");
		}
		System.out.println(sb);
	}
	
	public static int compare(int[] a, int[] b, int index) {
		if(		a[index] > b[index]) return 1;
		else if(a[index] < b[index]) return 2;
		else if(index == 0) return 0;
		else return compare(a, b, index-1);
	}
}
