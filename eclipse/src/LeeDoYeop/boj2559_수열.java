package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2559_수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		int max = sum;
		if (N > K) {
			for (int i = 1; i <= N - K; i++) {
				sum = sum - arr[i - 1] + arr[i + K - 1];
				max = Math.max(sum, max);
			}
		}
		if (K == 1) {
			for (int i = 1; i < N; i++) {
				sum = arr[i];
				max = Math.max(sum, max);
			}
		}
		System.out.println(max);
	}
}
