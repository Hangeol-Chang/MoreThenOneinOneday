package LeeDoYeop;
import java.util.Scanner;

public class boj1085 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();
	int y = sc.nextInt();
	int w = sc.nextInt();
	int h = sc.nextInt();
	int[] minarray = {x, y, Math.abs(w-x), Math.abs(h-y)}; 
	int min = 10000;
	for(int i = 0; i<4; i++) {
		if(minarray[i]< min)
			min = minarray[i];
	}
	System.out.println(min);
	}
}
