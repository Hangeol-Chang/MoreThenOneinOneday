
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SWEA6190_정곤이의단조증가하는수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			int n = Integer.parseInt(br.readLine());
			
			int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int max = -1;
			//모든 경우에 대해 실행. 다 곱해봄.
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					int num = nums[i] * nums[j];
					
					//1의 자리부터 하나씩 올라가면서,
					//숫자가 감소하는지 확인.
					boolean is = true;
					int nownum = 10;
					while(num > 0) {
						int tmp = nownum - num%10;
						
						//숫자가 감소하지 않으면 브레이크,
						//감소하면 다음 자리 판단.
						if(tmp < 0) {
							is = false;
							break;
						}else {
							nownum = num%10;
							num /= 10;
						}
					}
					if(is) {
						if(max < nums[i]*nums[j]) max = nums[i] * nums[j];
					}
				}
			}
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
}
