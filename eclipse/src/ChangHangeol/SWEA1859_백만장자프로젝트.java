package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SWEA1859_백만장자프로젝트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			long earn = 0;
			
			int n = Integer.parseInt(br.readLine());
			int[] price = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int pricenow = price[n-1];
			for(int i = n-2; i >= 0; i--) {
				if(pricenow < price[i]) pricenow = price[i];
				else earn += pricenow - price[i];
			}
			
			sb.append(earn+"\n");
		}
		System.out.println(sb);
	}
}
