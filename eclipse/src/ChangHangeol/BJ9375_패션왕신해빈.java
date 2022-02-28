package ChangHangeol;
import java.util.HashMap;
import java.util.Scanner;

public class BJ9375_패션왕신해빈 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1; t <= T; t++) {
			HashMap<String, Integer> dress = new HashMap<>();
			int n = in.nextInt();
			in.nextLine();
			//입력받아서 해쉬셋에 더하기.
			for(int i = 0; i < n; i++) {
				String[] have = in.nextLine().split(" ");
				if(dress.get(have[1]) != null) dress.put(have[1], dress.get(have[1])+1);
				else 						   dress.put(have[1], 1);
			}
			int gazi = 1;
			//System.out.println(dress);
			for(int num : dress.values()) gazi *= num+1;
			
			sb.append(gazi-1 + "\n");
		}
		System.out.print(sb);
		in.close();
	}
}
