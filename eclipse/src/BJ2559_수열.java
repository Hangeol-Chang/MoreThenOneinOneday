
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		//맥스를 첫번째 부분합으로 초기화 
		int max = 0;
		for(int i = 0; i < k; i++) max += arr[i];
		
		for(int i = 1; i < n-k+1; i++) {
			int tmp = 0;
			for(int j = 0; j < k; j++) tmp += arr[i+j];
			if(tmp > max) max = tmp;
		}
		System.out.println(max);
	}
}
