package ChangHangeol;
import java.util.Scanner;

public class SWEA5432 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t +" ");
			
			String str = in.nextLine();
			int len = str.length();
			
			int count = -1;
			int sum = 0;
			boolean opened = true;
			for(int i = 0; i < len; i++) {
				if(str.charAt(i) == '(') {
					count++;
					opened = true;
				}else {
					if(opened) { sum += count--;
					}else {		 sum++; count--;}
					opened = false;
				}
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
}



