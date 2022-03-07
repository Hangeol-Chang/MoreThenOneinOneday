package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2822_점수계산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr1 = new int[8];
		int[] arr2 = new int[8];
		for(int i = 0; i<8; i++) {
			int num = Integer.parseInt(br.readLine());
			arr1[i] = num;
			arr2[i] = num;
		}
		int sum = 0;
		Arrays.sort(arr2);
		for(int i = 3; i<8; i++)
			sum+=arr2[i];
		sb.append(sum).append("\n");
		for(int i = 0; i<8; i++) {
			if(arr1[i] != arr2[0] && arr1[i] != arr2[1] && arr1[i] != arr2[2])
				sb.append(i+1).append(" ");
		}
		System.out.println(sb.toString());
	}
}
