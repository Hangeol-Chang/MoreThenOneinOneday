
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 마이쮸 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>();
		
		int[] arr = new int[20];
		int food = 20;
		
		int i = 1;
		int pop = 0;
		while(food > 0) {	
			que.add(i);
			pop = que.poll();
			food -= ++arr[pop];
			que.add(pop);
			System.out.println("남은 음식 : " + food + ", 가져간 애 : " + pop + ", 가져간 양 : " + arr[pop] + ", 현재 대기열 : "  + que);
			i++;
		}
		System.out.println(pop);
		in.close();
	}
}
