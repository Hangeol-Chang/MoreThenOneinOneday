package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2018_수들의합5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		for(int i = 1; i<=N/2; i++) {
			int sum = 0;
			for(int j = i; j<=N/2+1; j++) {
				sum += j;
				if(sum == N) {
					cnt++;
					break;
				}
				else if (sum>N)
					break;
			}
		}
		System.out.println(cnt);
	}
}
