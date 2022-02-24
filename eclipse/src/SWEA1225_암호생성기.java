import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SWEA1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			br.readLine();
			int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//전체 사이클 포문
			int idx = 0;
			와일 : while(true) {
				//1~5까지 감소시킬 포문
				for(int i = 1; i <= 5; i++) {
					nums[idx] -= i;
					if(nums[idx] <= 0) {
						nums[idx] = 0;
						break 와일;
					}
					idx = (idx+1)%8;
				}
			}
			idx = (idx+1)%8;
			while(nums[idx] != 0) {
				sb.append(nums[idx] + " ");
				idx = (idx+1)%8;
			}
			sb.append(nums[idx] + "\n");
		}
		System.out.println(sb);
		
		//0된 idx를 가져나와서, 그 다음부터 출력.
	}
}
