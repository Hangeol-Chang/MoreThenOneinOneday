

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2420_사파리월드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long a = Long.parseLong(st.nextToken());
		Long b = Long.parseLong(st.nextToken());
		
		System.out.print(Math.abs(a - b));
	}
}
