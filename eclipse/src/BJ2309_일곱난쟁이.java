
import java.util.Arrays;
import java.util.Scanner;

public class BJ2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] h = new int[9];
		for(int i = 0; i < 9; i++) h[i] = in.nextInt();
		
		Arrays.sort(h);
		powerset(8, h, 0, 0);
		in.close();
	}
	
	/**
	 * 오름차순으로 난쟁이의 키를 정렬해 놓았고,
	 * 이를 역순으로 뒤지면서, 다 뒤져보고 키가 100이 되는 최초에,
	 * true를 리턴하면서 그 때 더했던 값들을 전부 출력.
	 */
	public static boolean powerset(int index, int[] arr, int sum, int count) {
		if (index == -1){
			if(sum == 100 && count == 7) return true;
			return false;
		}
		//나를 안더할 때 100이 가능한지 판단.
		boolean judge = powerset(index - 1, arr, sum, count);
		if(judge) return true;
		
		//나를 더할 때 100이 가능한지 판단.
		judge = powerset(index - 1, arr, sum+arr[index], count + 1);
		if(judge) {
			System.out.println(arr[index]);
			return true;
		}
		return false;
	}
}
