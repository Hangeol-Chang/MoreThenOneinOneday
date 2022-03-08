package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1107_리모컨 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[10];
		if(M != 0) {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<M; i++) {
			int cNum = Integer.parseInt(st.nextToken());
			check[cNum] = !check[cNum];
		}
		}
		int num = Math.abs(N-100);
		
		for(int i = 0; i<=999999; i++) {
			String strI = String.valueOf(i);
			int strLen = strI.length();
			boolean checkNum = true;
			for(int j = 0; j<strLen; j++) {
				if(check[strI.charAt(j)-'0']) {
					checkNum = !checkNum;
					break;
				}
			}
			if(checkNum) {
				int cnt = Math.abs(N-i) + strLen;
				num = Math.min(cnt, num);
			}
		}
		System.out.println(num);
	}
}
