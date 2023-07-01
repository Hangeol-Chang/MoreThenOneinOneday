

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1920_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> data = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			data.add(Integer.parseInt(st.nextToken()));
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(data.contains(num) ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
}
