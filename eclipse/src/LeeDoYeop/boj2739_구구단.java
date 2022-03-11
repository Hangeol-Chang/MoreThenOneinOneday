package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2739_구구단 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i<=9; i++) {
			sb.append(N).append(" ").append("* ").append(i).append(" ").append("= ").append(N*i).append("\n");
		}
		System.out.println(sb.toString());
	}
}
