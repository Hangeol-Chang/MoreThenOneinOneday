package ChangHangeol;
import java.util.Scanner;

public class SWEA3499_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1; t<=T;t++) {
			sb.append("#" + t + " ");
			
			int n = in.nextInt();
			int hfn = (n+1)/2;
			in.nextLine();
			String[] arr = in.nextLine().split(" ");
			
			int idx = 0;
			while(idx < n) {
				//2의 나머지를 hfn에 곱해서, idxtmp자체가
				//앞에꺼, 뒤에꺼를 번갈아서 고르게 함.
				int idxtmp = idx / 2 + (idx%2)*hfn;
				sb.append(arr[idxtmp] + " ");
				idx++;
			}
			sb.append("\n");
		}
		System.out.println(sb);
		in.close();
	}
}
