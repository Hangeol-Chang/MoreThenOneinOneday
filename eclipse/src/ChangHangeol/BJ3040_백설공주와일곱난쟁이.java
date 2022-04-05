package ChangHangeol;

import java.util.Scanner;

public class BJ3040_백설공주와일곱난쟁이 {
	static boolean[] visited = new boolean[9];
	static boolean finished;
	static int[] skswoddl = new int[9];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 9; i++) { skswoddl[i] = in.nextInt(); }
		// 입력 끝.
		in.close();
		
		dlfmaanjfhgkwl(0, 0);
	}
	public static void dlfmaanjfhgkwl(int num, int sum) {
		if(num == 7) {
			if(sum == 100) {
				for(int j = 0; j < 9; j++) {
					if(visited[j]) System.out.println(skswoddl[j]);
				}
				finished = true;
			}
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(finished) return;
			
			if(visited[i]) continue;
			visited[i] = true;
			
			dlfmaanjfhgkwl(num+1, sum + skswoddl[i]);
			visited[i] = false;
		}
	}
}
