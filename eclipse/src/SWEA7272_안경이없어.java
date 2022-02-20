import java.util.Scanner;

/**
 * ADOPQR B
 */

public class SWEA7272_안경이없어 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String ref0 = "[CEFGHIJKLMNSTUVWXYZ]";
		String ref1 = "[ADOPQR]";
		
		int T = in.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			String str1 = in.next();
			String str2 = in.next();
			
			str1 = str1.replaceAll(ref0, "0").replaceAll(ref1,  "1");
			str2 = str2.replaceAll(ref0, "0").replaceAll(ref1,  "1");
			
			if(str1.equals(str2)) sb.append("SAME\n");
			else sb.append("DIFF\n");
		}
		System.out.println(sb);
		in.close();
	}
}
