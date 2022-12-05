
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SWEA1961_숫자배열회전 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + "\n");
			int n = Integer.parseInt(br.readLine());
			
			int[][] nums = new int[n][];
			for(int i = 0; i < n; i++) nums[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int i = 0; i < n; i++) {
				for(int r90 = n-1; r90 >= 0; r90--) sb.append(nums[r90][i]);
				sb.append(" ");
				for(int r180 = n-1; r180 >= 0; r180--) sb.append(nums[n-1-i][r180]);
				sb.append(" ");
				for(int r270 = 0; r270 < n; r270++) sb.append(nums[r270][n-1-i]);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
