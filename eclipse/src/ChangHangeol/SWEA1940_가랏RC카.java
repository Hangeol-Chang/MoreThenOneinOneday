package ChangHangeol;
import java.util.Scanner;

public class SWEA1940_가랏RC카 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int[] d = { 1, -1};
		int T = in.nextInt();
		for(int t = 1; t <= T; t++) {
			int speed = 0;
			int distance = 0;
			
			int orders = in.nextInt();
			for(int o = 0; o < orders; o++) {
				int mod = in.nextInt();
				
				switch(mod) {
				case 1:
				case 2:
					int cha = in.nextInt();
					speed += d[mod-1]*cha;
					if(speed < 0) speed = 0;
				case 0:
					distance += speed;
				}
			}
			sb.append("#" + t + " " + distance + "\n");
		}
		System.out.println(sb);
		in.close();
	}
}
