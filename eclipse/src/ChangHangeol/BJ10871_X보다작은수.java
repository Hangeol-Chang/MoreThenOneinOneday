package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10871_X보다작은수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int ref = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int idf = Integer.parseInt(st.nextToken());
			if(idf < ref) sb.append(idf + " ");
		}
		System.out.println(sb);
	}
}
