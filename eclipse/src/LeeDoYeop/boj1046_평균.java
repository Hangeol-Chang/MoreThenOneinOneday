package LeeDoYeop;
import java.util.Scanner;

public class boj1046_평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double sum = 0;
		double max = 0;
		double[] arr = new double[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextDouble();
			max = Math.max(arr[i],max);
		}
		for(int i = 0; i<N; i++) {
			arr[i] = arr[i]/max*100;
			sum += arr[i];
		}
		
		double average = sum/N;
		System.out.println(average);
	}
}
